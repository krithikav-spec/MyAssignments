package week3.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountDropDown {

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
		//to goto accounts page
		driver.findElement(By.linkText("Accounts")).click();
		// to create an account
		driver.findElement(By.linkText("Create Account")).click();
		// enter account name, number of employees , site
		driver.findElement(By.id("accountName")).sendKeys("TesterK");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation learming");
		WebElement dropDownelement = driver.findElement(By.name("ownershipEnumId"));
		Select option = new Select(dropDownelement);
		option.selectByVisibleText("S-Corporation");
		WebElement dropDownelement2 = driver.findElement(By.name("industryEnumId"));
		Select option2 = new Select(dropDownelement2);
		option2.selectByValue("IND_SOFTWARE");
		WebElement dropDownelement3 = driver.findElement(By.id("dataSourceId"));
		Select option3 = new Select(dropDownelement3);
		option3.selectByValue("LEAD_EMPLOYEE");
		WebElement dropDownelement4 = driver.findElement(By.id("marketingCampaignId"));
		Select option4 = new Select(dropDownelement4);
		option4.selectByIndex(6);
		WebElement dropDownelement5 = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select option5 = new Select(dropDownelement5);
		option5.selectByValue("TX");
		//submit and get title
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("the title is " + driver.getTitle());
		driver.close();

	}

}
