package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

@SuppressWarnings("unused")

public class ServiceNowMarathon {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		// 1.Load URL and Maximize window, implicit wait
		driver.get("https://dev266363.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// 2.enter user id , password and enter
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("CSO=y7Fc7m@c", Keys.ENTER);
		// initialize shadow class
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		// 3.find elements inside shadow DOM, select Service catalog in the All and
		// click
		shadow.findElementByXPath("//div[text()='All']").click();
		shadow.findElementByXPath("//span[contains(text(),'Service Catalog')]").click();
		// 4.Click on mobiles
		WebElement iframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(iframe);
		shadow.findElementByXPath("//h2[contains(text(),'Mobiles')]").click();

		// 5. select iphone 13 pro
		// WebElement iframe2 =
		// shadow.findElementByXPath("//iframe[@name='gsft_main']");
		// driver.switchTo().frame(iframe2);
		shadow.findElementByXPath("//h3[contains(text(),'Apple iPhone 13 pro')]").click();
		Thread.sleep(3000);
		// 6.Choose yes option in lost or broken iPhone- radio button
		WebElement yesOption = shadow.findElementByXPath(
				"//div[legend[span[text()='Is this a replacement for a lost or broken iPhone?']]]/following-sibling::div//label[text()='Yes']");
		yesOption.click();
		// 7. Enter phonenumber as 99 in original phonenumber field
		shadow.findElementByXPath(
				"//div[label[span[text()='What was the original phone number?']]]/following-sibling::div//input[not(@type='HIDDEN')]")
				.sendKeys("99");
		// 8. Select Unlimited from the dropdown in Monthly data allowance
		Select optionDataAllowance = new Select(
				shadow.findElementByXPath("//select"));
		optionDataAllowance.selectByValue("unlimited");
		// 9. Update color field to SierraBlue and storage field to 512GB
		shadow.findElementByXPath(
				"//div[legend[span[contains(text(),'colour')]]]/following-sibling::div//label[text()='Sierra Blue']")
				.click();
		//Thread.sleep(2000);
		shadow.findElementByXPath(
				"//div[legend[span[text()='Choose the storage']]]/following-sibling::div//label[contains(text(),'512')]")
				.click();

		Thread.sleep(2000);
		// 10. Click Order Now
		shadow.findElementByXPath("//button[contains(text(),'Order Now')]").click();
		//11. Verify order is placed and copy the request number
		Thread.sleep(2000);
		String requestNumber= shadow.findElementByXPath("//a[@id='requesturl']").getText();
		//String requestNumber1= requestNumber.getText();
		
		System.out.println("request number -"+requestNumber);
		if (requestNumber.isEmpty())
		{
			System.out.println("order NOT placed");
		}
		else {
	
			System.out.println("order  placed");}
		// 12. Take a Snapshot of order placed page
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./data/servicenow.png");
		FileUtils.copyFile(source, destination);
				driver.quit();

		
		
	}

}
