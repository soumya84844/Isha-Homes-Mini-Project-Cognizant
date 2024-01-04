package SeleniumTesting;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;


public class WriteExcelFile {
	
	public void writeExcelData(List<WebElement> projects) throws Exception {
		
		System.out.println("\n\nWriting to Excel File ..............");
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\excel\\test_data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Completed Projects");
		
		for(int i = 0; i < projects.size(); i++) {
			
			sheet.createRow(i).createCell(0).setCellValue(projects.get(i).getText());
			
		}
		
		workbook.write(file);
		
		workbook.close();
		file.close();
		
	}

}
