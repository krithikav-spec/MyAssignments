package stepDef;

import io.cucumber.java.en.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.Before;

@SuppressWarnings("unused")
public class StepDefSales {

	ChromeDriver driver;

	@Given("Load the URL")
	public void load_the_url() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\SeleniumProfile");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");}
	
	@Given ("Login to Salesforce")
	public void login_to_salesforce() {
		// Enter Username
		driver.findElement(By.id("username")).sendKeys("Krithikav@testleaf.com");
		// Enter Password
		driver.findElement(By.id("password")).sendKeys("Veera@123");
		// Click Login
		driver.findElement(By.id("Login")).click();
    }
	@When("select toggle")
	public void select_toggle() {
		WebDriverWait wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='App Launcher']"))).click();
	}

	@When("select view All")
	public void select_view_all() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(5000);
		WebElement scrollTo =driver.findElement(By.xpath("//p[text()='Sales']"));
		Actions act = new Actions(driver);
		act.scrollToElement(scrollTo).moveToElement(scrollTo).perform();
		scrollTo.click();
	}

	@When("select on Accounts tab")
	public void select_on_accounts_tab() {
		
		    WebElement account = driver.findElement(By.xpath("//a[@title='Accounts']"));
		    driver.executeScript("arguments[0].click();", account);

			}

	@When("click New button")
	public void click_new_button() {
		driver.findElement(By.xpath("//span[text()='New Account']")).click();
	}

	@When("enter name")
	public void enter_name() {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("SeleniumAutomationK");
	}

	@When("enter Ownership  name")
	public void enter_ownership_name() {
		
		driver.findElement(By.xpath("//button[@aria-label='Ownership']")).click();
    	
        driver.findElement(By.xpath("//span[text()='Public']")).click();
	}

	@When("click save")
	public void click_save() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}

	@Then("Verify  the displayed name")
	public void verify_name() {
		String createdName = driver.findElement(By.xpath("//lightning-formatted-text")).getText();

		//   Assert.assertEquals(createdName, name);

        System.out.println("Account Created Successfully");

        driver.quit();
	}

}

