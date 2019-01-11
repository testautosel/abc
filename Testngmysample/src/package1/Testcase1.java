package package1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Testcase1 {

	
	@Test()
	public void testCase1() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"D://Automation_Document//AyeshaWorkspace1//MyFirstAutomationProject//DriverServers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://login.yahoo.com");
		String fbTitle=driver.getTitle();
		System.out.println(fbTitle);
		WebElement emailElement=driver.findElement(By.id("login-username"));
		emailElement.sendKeys("ayesha_banusyed");//for text box
		
		TakesScreenshot yy =((TakesScreenshot)driver);
		File xx=yy.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(xx, new File("./ScreenShots/home.png"));
		
		
		//WebElement loginBtnElement=driver.findElement(By.id("loginbutton"));
		WebElement nextBtnElement=driver.findElement(By.id("login-signin"));
		nextBtnElement.click();
		
		String currentUrl=driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		String currentUrlTitle=driver.getTitle();
		System.out.println(currentUrlTitle);
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-signin")));
		
		
		
		WebElement passWordElement=driver.findElement(By.id("login-passwd"));
		passWordElement.sendKeys("123456abcd");//for text box
		//using java script executor click button
		
		WebElement signinBtnElement=driver.findElement(By.id("login-signin"));
				signinBtnElement.click();
		
		/*String currentUrl1=driver.getCurrentUrl();
		System.out.println(currentUrl1);
		
		String currentUrlTitle1=driver.getTitle();
		System.out.println(currentUrlTitle1); */
		
		driver.quit();
	}

	

		
	}
