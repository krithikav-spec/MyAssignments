package week3.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLeadXpath {

	public static void main(String[] args) {
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

		// click on Leads tab
		driver.findElement(By.linkText("Leads")).click();
		// click on create lead
		driver.findElement(By.linkText("Create Lead")).click();
		//parent to child
		driver.findElement(By.xpath("//td[input[@id='createLeadForm_firstName']]/input")).sendKeys("KTester");
		//grandparent to child
		driver.findElement(By.xpath("//tbody//input[@id='createLeadForm_lastName']")).sendKeys("Yellow12");
		driver.findElement(By.xpath("//td[input[@id='createLeadForm_companyName']]/input")).sendKeys("IPL");
		driver.findElement(By.xpath("//td[input[@id='createLeadForm_generalProfTitle']]/input")).sendKeys("Ms.");
		driver.findElement(By.className("smallSubmit")).click();;
		System.out.println("the title is " + driver.getTitle());
		driver.close();

	}

}
