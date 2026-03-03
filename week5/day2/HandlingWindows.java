package week5.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@SuppressWarnings("unused")

public class HandlingWindows {

	public static void main(String[] args) throws InterruptedException {
		// initialize chrome driver
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(opt);
		// get the link- leaftaps
		driver.get("http://leaftaps.com/opentaps/control/login");
		// maximize the window
		driver.manage().window().maximize();
		// add an implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// enter user id and password and click on login
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoCSR2");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		// click on crm/sfa button
		driver.findElement(By.linkText("CRM/SFA")).click();
		// select contacts tab
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		// select merge contacts
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		// click on the from contact widget
		driver.findElement(By.xpath("//td[span[text()='From Contact']]/following-sibling::td//a")).click();
		// switching the focus to the new tab
		Set<String> mainWindow = driver.getWindowHandles();
		List<String> activeWindow = new ArrayList<String>(mainWindow);
		Thread.sleep(2000);
		driver.switchTo().window(activeWindow.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']")).click();
		// switch back to merge contact window
		driver.switchTo().window(activeWindow.get(0));
		// click on merge
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		// handling alert- switch focus to alert
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		// get the title of the page
		
	
		String title1 = driver.getTitle();
		System.out.println(title1);

		

	}

}
