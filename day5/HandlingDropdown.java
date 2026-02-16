package week3.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdown {

	public static void main(String[] args) {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(opt);
// open leaftaps link
		driver.get("http://leaftaps.com/opentaps/control/main");
		// maximize window
		driver.manage().window().maximize();
		// to enter user id and password
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// click on login
		driver.findElement(By.className("decorativeSubmit")).click();
driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Tester");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("12");
		// company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("IPL");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Ms.");
		// by INDEX
		WebElement dropDownelement = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select option = new Select(dropDownelement);
		option.selectByIndex(3);
		// by value
		WebElement dropDownelement2 = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select option2 = new Select(dropDownelement2);
		option2.selectByValue("IND_AEROSPACE");
		// by visible text
		WebElement dropDownelement3 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select option3 = new Select(dropDownelement3);
		option3.selectByVisibleText("Demo Marketing Campaign");
driver.findElement(By.className("smallSubmit")).click();
System.out.println("the title is " + driver.getTitle());

		
		driver.close();

	}

}
