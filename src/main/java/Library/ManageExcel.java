package Library;

//import static Library.Browser.testDataExcelFileName;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ManageExcel {
	//Main Directory of the project
	public static  String testDataExcelFileName;
	
	//Location of Test data excel file
	public static String excelFilePath= null;
	
	//Excel WorkBook
	public static XSSFWorkbook workbook;
	
	//Excel Sheet
	public static XSSFSheet sheet;
	
	//Excel Row
	public static XSSFRow row;
	
	//Excel Cell
	public static XSSFCell cell;
	
	//Row Number
    public static int rowNumber;

    //Column Number
    public static int columnNumber;
	
	//Setter and Getters of row and columns
	public static int getRowNumber() {
		return rowNumber;
	}
	public static void setRowNumber(int rowNumber) {
		ManageExcel.rowNumber = rowNumber;
	}
	public static int getColumnNumber() {
		return columnNumber;
	}
	public static void setColumnNumber(int columnNumber) {
		ManageExcel.columnNumber = columnNumber;
	}
	
	
	public static void setExcelFileSheet(String sheetName) throws Exception
	{
		testDataExcelFileName= "C:\\Users\\Suyesha\\eclipse-workspaceNew\\Practice\\src\\main\\resources\\UserCredentials.xlsx";
		 //MAC or Windows Selection for excel path
      try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(testDataExcelFileName);
            workbook = new XSSFWorkbook(ExcelFile);
            sheet = workbook.getSheet(sheetName);
        } 
      catch(FileNotFoundException F )
      {
    	  System.out.println("File not found");
      }
      catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
	}
	
	
	public static Object[][] getTestData()
	{
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		System.out.println("last row number:"+ sheet.getLastRowNum());
		System.out.println("Last cell num:" +sheet.getRow(0).getLastCellNum() );
		
		for(int i=0;i < sheet.getLastRowNum();i++)
		{
			for(int k=0;k < sheet.getRow(0).getLastCellNum();k++)
			{
				if(sheet.getRow(i+1).getCell(k).toString()!= null)
			    data[i][k]= sheet.getRow(i+1).getCell(k).toString();	
			}
			
		}
		return data;
	}
	
	//This method reads the test data from the Excel cell.
    //We are passing row number and column number as parameters.
    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try {
            cell = sheet.getRow(RowNum).getCell(ColNum);
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        } catch (Exception e) {
            System.out.println("Cell value not available "+ RowNum+", "+ColNum);
            throw (e);
        }
    }
	
  //This method takes row number as a parameter and returns the data of given row number.
    public static XSSFRow getRowData(int RowNum) throws Exception {
        try {
            row = sheet.getRow(RowNum);
            return row;
        } catch (Exception e) {
            throw (e);
        }
    }
    
  //This method gets excel file, row and column number and set a value to the that cell.
    public static void setCellData(String value, int RowNum, int ColNum) {
        try {
            row = sheet.getRow(RowNum);
            cell = row.getCell(ColNum);
            if (cell == null) {
                cell = row.createCell(ColNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(excelFilePath + testDataExcelFileName);
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }
    
}
	
	
	
	
	
	
	
	
	
	


