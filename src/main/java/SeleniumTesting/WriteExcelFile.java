package SeleniumTesting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteExcelFile {
	
	public void writeExcelData(List<String> projectNames) throws Exception {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\excel\\test_data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Completed Projects");
		
		for(int i = 0; i < projectNames.size(); i++) {
			
			sheet.createRow(i).createCell(0).setCellValue(projectNames.get(i));
			
		}
		
		workbook.write(file);
		
		workbook.close();
		file.close();
		
	}

}
