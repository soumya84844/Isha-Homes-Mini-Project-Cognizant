package SeleniumTesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
	
	public WebDriver setUpWebDriver() {
		
		WebDriver driver = new ChromeDriver();
		
		return driver;
		
	}

}
