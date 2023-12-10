package SeleniumTesting;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class WebTest {
	
	static WebDriver driver;
	
	public void navigateToURL() {
		
		driver.get("https://ishahomes.com");
		
	}
	
//	public void handleAlert() {
//		
//		try {
//			
//			Alert alert = driver.switchTo().alert();
//			
//			System.out.println(alert.getText());
//			
//			alert.sendKeys(Credentials.userName + "\t" + Credentials.password);
//			
//			alert.accept();
//			
//		}
//		
//		catch(Exception e) {
//			
//			System.out.println("No Alert");
//			
//		}
//		
//	}
	
	public void closePopup() {
		
		driver.findElement(By.xpath("//a[@role='button']")).click();
		
	}
	
	public void maximizeBrowser() {
		
		driver.manage().window().maximize();
		
	}
	
	public void navigateToCompletedProjectsPage() {
		
		driver.findElement(By.xpath("//li[@id='menu-item-25810']/a")).click();
		
	}

	public void scroll() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='listing-thumb']")));
		
	}
	
	public List<String> listCompletedProjects() {
		
		List<WebElement> projects = driver.findElements(By.xpath("//div[@id='boosted-tab-0']/div[1]/section/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[1]/div[1]/h2/a"));
		
		System.out.println("\n\nTotal no. of Completed Projects = " + projects.size());
		
		System.out.println("\n\nNames of First 5 Completed Projects ---------------- ");
		
		List<String> projectNames = new ArrayList<String>();
		
		for(int i = 0; i < 5; i++) {
			
			System.out.println(projects.get(i).getText());
			projectNames.add(projects.get(i).getText());
		
		}
		
		return projectNames;
		
	}
	
	public void clickEnquireNow() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//ul[@class='elementor-icon-list-items']/li[1]/a")));
		
		driver.findElement(By.xpath("/html/body/footer/section/div/div/div/section[1]/div/div[2]/div/div[2]/div/ul/li[1]/a")).click();
		
	}
	
	public void verifyContactUs() {
		
		if(driver.findElement(By.xpath("//h1[@class='elementor-heading-title elementor-size-default']")).getText().equals("CONTACT US")) {
			
			System.out.println("\n\nContact Us Verified\n\n");
			
		}
		
	}
	
	public void printEmail() {
		
		System.out.println("Email Address for Contact : " + driver.findElement(By.xpath("//a[contains(@href, 'mailto')]")).getText() + "\n\n");
		
	}
	
	public void captureScreenshot() throws Exception {
		
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\screenshot\\screenshot.png"));
		
//		String screenshotBase64 = ((TakesScreenshot)driver).getScreenshotAs(System.getProperty("user.dir") + "\\screenshot\\screenshot.png");
		
	}
	
	public void closeBrowser() {
		
		driver.quit();
		
	}
	
	public static void main(String[] args) throws Exception {
		
		DriverSetup driverSetup = new DriverSetup();
		WriteExcelFile wef = new WriteExcelFile();
		Scanner sc = new Scanner(System.in);
		
		int ch;
		
		do {
			
			System.out.println("\n\nEnter 1. for Chrome\nEnter 2. for Edge\nEnter your choice : ");
			
			ch = sc.nextInt();
			
			if(ch != 1 && ch != 2) {
				
				System.out.println("\n\nInvalid Choice !!! Enter choice again !!!");
				
			}
			
			else {
				
				break;
				
			}
			
		} while(true);
		
		driver = driverSetup.setUpWebDriver(ch);
		
		WebTest wt = new WebTest();
		
		wt.navigateToURL();
		
		Thread.sleep(10000);
		
//		wt.handleAlert();
		
		Thread.sleep(5000);
		
		wt.maximizeBrowser();
		
		Thread.sleep(10000);
		
		wt.closePopup();
		
		Thread.sleep(2000);
		
		wt.navigateToCompletedProjectsPage();
		
		Thread.sleep(10000);
		
		wt.closePopup();
		
		Thread.sleep(3000);
		
		wt.scroll();
		
		wef.writeExcelData(wt.listCompletedProjects());
		
		Thread.sleep(2000);
		
		wt.clickEnquireNow();
		
		Thread.sleep(10000);
		
		wt.closePopup();
		
		Thread.sleep(1000);
		
		wt.verifyContactUs();
		
		wt.printEmail();
		
		wt.captureScreenshot();
		
		wt.closeBrowser();
		
		sc.close();
		
//		System.out.println("Done");

	}

}
