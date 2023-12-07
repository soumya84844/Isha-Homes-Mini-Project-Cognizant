package SeleniumTesting;

import java.util.List;

import org.openqa.selenium.*;

public class WebTest {
	
	static WebDriver driver;
	
	public void navigateToURL() {
		
		driver.get("https://ishahomes.com");
		
	}
	
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
	
	public void listCompletedProjects() {
		
		List<WebElement> projects = driver.findElements(By.xpath("//div[@id='boosted-tab-0']/div[1]/section/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[1]/div[1]/h2/a"));
		
		System.out.println("Total no. of Completed Projects = " + projects.size());
		
		System.out.println("Names of First 5 Completed Projects ---------------- ");
		
		for(int i = 0; i < 5; i++) {
			
			System.out.println(projects.get(i).getText());
		
		}
		
	}
	
	public void clickEnquireNow() {
		
		driver.findElement(By.xpath("//div[@class='mci-ph enq-tooltip-new']")).click();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		DriverSetup driverSetup = new DriverSetup();
		
		driver = driverSetup.setUpWebDriver();
		
		WebTest wt = new WebTest();
		
		wt.navigateToURL();
		
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
		
		wt.listCompletedProjects();
		
		Thread.sleep(2000);
		
		wt.clickEnquireNow();
		
//		System.out.println("Done");

	}

}
