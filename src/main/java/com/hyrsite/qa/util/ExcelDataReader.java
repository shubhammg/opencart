
package com.hyrsite.qa.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataReader {
	
	/*String name;
	String age;
	String email;
ExcelDataReader (String name , String age, String email){
 	this.name=name;
	this.age=age;
	this.email=email;}*/
	
	
	

	
	static String path="C:\\\\Users\\\\tando\\\\eclipse-workspace\\\\Testing\\\\src\\\\main\\\\java\\\\com\\\\hyrsite\\\\qa\\\\testdata\\\\TestData.xlsx";
    static String Sheet="Details";
  //@DataProvider(name = "excelData")
    //create method returning Object array type of data 
    public static Object[][] readExcel() throws IOException {
        // Provide path of the Excel file
        FileInputStream fis = new FileInputStream(path);

        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // Select the sheet which has data
        XSSFSheet sheet = workbook.getSheet(Sheet);

        // Count number of rows and columns
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        // Create an object array to store data from Excel
        Object[][] data = new Object[rowCount-1][colCount];

        // Loop through each row in the sheet
        for (int i = 1; i < rowCount; i++) {
            XSSFRow row = sheet.getRow(i);

            // Loop through each cell in the row
            for (int j = 0; j < colCount; j++) {
                XSSFCell cell = row.getCell(j);

                // Check the cell type and get the value accordingly
                if (cell.getCellType() == CellType.STRING) {
                    data[i-1][j] = cell.getStringCellValue();
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    data[i-1][j] = String.valueOf(cell.getNumericCellValue());
                }
            }
        }

        // Close the workbook and file streams
        fis.close();
        workbook.close();

        return data;
    }

	/*
	 * @Test(dataProvider = "excelData") public void testData(String name, String
	 * age, String email) { // Write your test code using the data provided by Data
	 * Provider System.out.println("Name: " + name + ", Age: " + age + ", Email: " +
	 * email); }
	 */
   
}
