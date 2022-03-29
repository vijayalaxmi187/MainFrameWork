package practice;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	public String getData(String sheetName,int row,int cell) throws Exception, IOException {
		FileInputStream fin = new FileInputStream("D:\\Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(fin);
		Sheet sh = workbook.getSheet(sheetName);
		Row rw= sh.getRow(row);
		String data = rw.getCell(cell).getStringCellValue();
		return data;
	}
}