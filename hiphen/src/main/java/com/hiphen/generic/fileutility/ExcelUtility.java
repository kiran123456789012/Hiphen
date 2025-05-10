package com.hiphen.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcelFile(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
FileInputStream fis=new FileInputStream("./src/test/resources/hiphen.testscriptdata.xlsx");
Workbook wb = WorkbookFactory.create(fis);
         String data = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
         return data;

    }
	public int  getLastRowNum(String key) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/hiphen.testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rownum = wb.getSheet(key).getLastRowNum();
		return rownum;
		
	}
	public void setDataBackToExcelFile(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException
	{
FileInputStream fis=new FileInputStream("./src/test/resources/hiphen.testscriptdata.xlsx");
Workbook wb = WorkbookFactory.create(fis);
           wb.getSheet(sheetname).getRow(rownum).createCell(cellnum).setCellValue(data);
           FileOutputStream fos=new FileOutputStream("./src/test/resources/testscriptdata.xlsx");
           wb.write(fos);
           wb.close();
           
         
        
    }
}
