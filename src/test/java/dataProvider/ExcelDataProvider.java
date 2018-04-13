package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider(){
		File src = new File("./ApplicationTestData/AppData.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is "+e.getMessage());
		} 
		
	}
	
	
	public String getdata(int sheetindex, int row, int column)
	{
		String data = wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public String getdata(String sheetname, int row, int column)
	{
		String data = wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		return data;
	}


}
