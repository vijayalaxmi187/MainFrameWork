package com.crm.autodeskgenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apachi Poi libraries,which used to handle Microsoft Excel sheet
 * @author Vijaylaxmi
 *
 */
public class ExcelUtility {
/**
 * its used to read the data from excel based on below arguments
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @return Date
 * @throws Throwable
 */
	public String getDataFromExcel(String sheetName,int rowNum,int CellNum)throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		
		String data = row.getCell(CellNum).getStringCellValue();
		wb.close();
		return data;
		
	}
	/**
	 * used to get the last used row number on specified sheet
	 * @param sheetName
	 * @return Throwable
	 */
	public int getRowCount(String sheetName)throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		wb.close();
		return sheet.getLastRowNum();
				}
	public void setDataExcel(String sheetName,int rowNum,int cellNum,String data)throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cel=row.createCell(cellNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\testdata.xlsx");
		wb.write(fos);
		wb.close();
	}
	
}
