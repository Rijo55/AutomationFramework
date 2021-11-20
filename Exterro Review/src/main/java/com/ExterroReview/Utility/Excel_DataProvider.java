package com.ExterroReview.Utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_DataProvider 
{
	
	XSSFWorkbook wb;  /*--->(Class from Apache POI to Accept XLSX files)*/
	
	public Excel_DataProvider(String excelPath) 
	{
		try 
		{
			File src=new File(excelPath);
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} 
		
		catch (Exception e) 
		{
			System.out.println("Unable to read Excel file. "+e.getMessage());
		} 
	}
	
	/*To Accept Sheet Index,Row and Column Number*/	
	public String getSheetIndex(int sheetIndex,int rowNum,int cellNum)
	{
		return wb.getSheetAt(sheetIndex).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
	
	/*To Accept Sheet Name,Row and Column Number*/
	public String getSheetName(String sheetName,int rowNum,int cellNum)
	{
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}	
}
