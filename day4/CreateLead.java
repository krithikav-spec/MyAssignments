package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLead {

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
		
		//click on Leads tab
		driver.findElement(By.linkText("Leads")).click();
		//click on create lead
		driver.findElement(By.linkText("Create Lead")).click();
		
		//add details first name and last name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Tester123");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("kkkk");
		//company name 
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("IPL");
		//title
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Ms.");
		//click on create lead button
		driver.findElement(By.className("smallSubmit")).click();
		//print the title
		
		System.out.println("the title is "+ driver.getTitle());
		// close the browser window
		driver.close();

	}

}
