package SeleniumTesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverSetup {
	
	public WebDriver setUpWebDriver(int ch) {
		
		WebDriver driver;
		
		if(ch == 1) {
			
			ChromeOptions chromeoption=new ChromeOptions();
			chromeoption.addArguments("--headless=new");
			
			driver = new ChromeDriver(chromeoption);
			
		}
		
		else {
			
			EdgeOptions edgeoption=new EdgeOptions();
			edgeoption.addArguments("--headless=new");
			
			driver = new EdgeDriver(edgeoption);
			
		}
		
		return driver;
		
	}

}
