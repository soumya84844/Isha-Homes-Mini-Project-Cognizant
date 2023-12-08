package SeleniumTesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
	
	public WebDriver setUpWebDriver(int ch) {
		
		WebDriver driver;
		
		if(ch == 1) {
			
			driver = new ChromeDriver();
			
		}
		
		else {
			
			driver = new EdgeDriver();
			
		}
		
		return driver;
		
	}

}
