package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(opt);

		// open leaftaps link
		driver.get("http://leaftaps.com/opentaps/control/main");
		// maximize window
		driver.manage().window().maximize();
		// to enter user id and password
		driver.findElement(By.id("username")).sendKeys("DemoCSR2");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// click on login
		driver.findElement(By.className("decorativeSubmit")).click();
		// click on crm/sfa button
		driver.findElement(By.linkText("CRM/SFA")).click();
		// to goto accounts page
		driver.findElement(By.linkText("Accounts")).click();
		// to create an account
		driver.findElement(By.linkText("Create Account")).click();

		// enter account name, number of employees , site
		driver.findElement(By.id("accountName")).sendKeys("tester11");
		// driver.findElement(By.name("description")).sendKeys("Selenium Automation
		// learming");
		driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");
		driver.findElement(By.id("numberEmployees")).sendKeys("15");

		// click on create account
		driver.findElement(By.className("smallSubmit")).click();
		// close the browser window
		driver.close();

	}

}
