package SeleniumTesting;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class WebTest {
	
	static WebDriver driver;
	
	public void navigateToURL() {
		
		System.out.println("\n\nFetching Isha Homes page ........");
		driver.get("https://ishahomes.com");
		
	}
	
	public void closePopup() {
		
		try {
			
			System.out.println("\n\nClosing pop-up ............");
			driver.findElement(By.xpath("//a[@role='button']")).click();
			
		}
		
		catch(Exception e) {
			
			System.out.println("\n\nPop-up not found !!!");
			
		}
		
	}
	
	public void closeLiveChat() {
		
		try {
			
			System.out.println("\n\nClosing Live Chat ........");
			driver.findElement(By.id("livchat_close")).click();
			
		}
		
		catch(Exception e) {
			
			System.out.println("\n\nLive Chat not found !!!");
			
		}
		
	}
	
	public void closeChatPopup() {
		
		try {
			
			System.out.println("\n\nClosing Chat Pop-up ............");
			driver.findElement(By.className("close-indicator")).click();
			
		}
		
		catch(Exception e) {
			
			System.out.println("\n\nChat Pop-up not found !!!");
			
		}
		
	}
	
	public void maximizeBrowser() {
		
		System.out.println("\n\nMaximizing Browser Window .........");
		driver.manage().window().maximize();
		
	}
	
	public void navigateToCompletedProjectsPage() {
		
		System.out.println("\n\nNavigating to Completed Projects Page ...........");
		driver.findElement(By.xpath("//li[@id='menu-item-25810']/a")).click();
		
	}

	public void scroll() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		System.out.println("\n\nScrolling the page ......");
		
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@class='listing-thumb']")));
		
	}
	
	public List<WebElement> listCompletedProjects() {
		
		List<WebElement> projects = driver.findElements(By.xpath("//div[@id='boosted-tab-0']/div[1]/section/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[1]/div[1]/h2/a"));
		
		System.out.println("\n\nTotal no. of Completed Projects = " + projects.size());
		
		System.out.println("\n\nNames of First 5 Completed Projects ---------------- ");
		
		for(int i = 0; i < 5; i++) {
			
			System.out.println(projects.get(i).getText());
		
		}
		
		return projects;
		
	}
	
	public void clickEnquireNow() {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//ul[@class='elementor-icon-list-items']/li[1]/a")));
		
		System.out.println("\n\nClicking Enquire Now .........");
		
		driver.findElement(By.xpath("/html/body/footer/section/div/div/div/section[1]/div/div[2]/div/div[2]/div/ul/li[1]/a")).click();
		
	}
	
	public void verifyContactUs() {
		
		if(driver.findElement(By.xpath("//h1[@class='elementor-heading-title elementor-size-default']")).getText().equals("CONTACT US")) {
			
			System.out.println("\n\nContact Us Verified");
			
		}
		
		else {
			
			System.out.println("\n\nContact Us not Verified !!!");
			
		}
		
	}
	
	public void printEmail() {
		
		System.out.println("\n\nEmail Address for Contact : " + driver.findElement(By.xpath("//a[contains(@href, 'mailto')]")).getText());
		
	}
	
	public void captureScreenshot() throws Exception {
		
		System.out.println("\n\nCapturing Screenshot ..........");
		
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\screenshot\\screenshot.png"));
		
		System.out.println("\n\nScreenshot Captured !!!");
				
	}
	
	public void closeBrowser() {
		
		System.out.println("\n\nClosing Browser ...........");
		
		driver.quit();
		
	}
	
	public static void main(String[] args) throws Exception {
		
		DriverSetup driverSetup = new DriverSetup();
		WriteExcelFile wef = new WriteExcelFile();
		WebTest wt = new WebTest();
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
		
		wt.navigateToURL();
		
		Thread.sleep(5000);
		
		wt.maximizeBrowser();
		
		Thread.sleep(5000);
		
		wt.closePopup();
		wt.closeLiveChat();
		wt.closeChatPopup();
		
		Thread.sleep(2000);
		
		wt.navigateToCompletedProjectsPage();
		
		Thread.sleep(5000);
		
		wt.closePopup();
		wt.closeLiveChat();
		wt.closeChatPopup();
		
		Thread.sleep(3000);
		
		wt.scroll();
		
		wef.writeExcelData(wt.listCompletedProjects());
		
		Thread.sleep(2000);
		
		wt.clickEnquireNow();
		
		Thread.sleep(5000);
		
		wt.closePopup();
		wt.closeLiveChat();
		wt.closeChatPopup();
		
		Thread.sleep(1000);
		
		wt.verifyContactUs();
		
		wt.printEmail();
		
		wt.captureScreenshot();
		
		wt.closeBrowser();
		
		sc.close();

	}

}
