package week3.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateLeadAdvancedXpath {

	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(opt);
		// open leaftaps link
		driver.get("http://leaftaps.com/opentaps/control/main");
		// maximize window
		driver.manage().window().maximize();
		// to enter user id and password
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// click on login
		driver.findElement(By.className("decorativeSubmit")).click();
		// click on crm/sfa button
		driver.findElement(By.linkText("CRM/SFA")).click();
		// click on Leads tab
		driver.findElement(By.linkText("Leads")).click();
		// click on create lead
		driver.findElement(By.linkText("Create Lead")).click();

		// elder to younger cousin-company name, first name, last name, first
		// name(local)
		driver.findElement(By.xpath("//span[text()='Company Name']/following::input[@id='createLeadForm_companyName']"))
				.sendKeys("CSK");
		driver.findElement(By.xpath("//span[text()='First name']/following::input[@id='createLeadForm_firstName']"))
				.sendKeys("KTester");
		driver.findElement(By.xpath("//span[text()='Last name']/following::input[@id='createLeadForm_lastName']"))
				.sendKeys("Selenium");
		driver.findElement(
				By.xpath("//span[text()='First Name (Local)']/following::input[@id='createLeadForm_firstNameLocal']"))
				.sendKeys("Ktester1");
		driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']"))
				.sendKeys("this is a test for advanced xpath");
		driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("automation testing");
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("K1112345@gmail.com");
		// select dropdown
		WebElement dropDownelement = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select option = new Select(dropDownelement);
		option.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		
		System.out.println("the title is " + driver.getTitle());
		driver.close();

		

	}

}