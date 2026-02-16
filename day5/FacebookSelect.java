package week3.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FacebookSelect {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(opt);
		// open facebook link
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Create new account")).click();
		driver.findElement(By.name("firstname")).sendKeys("TesterK");
		driver.findElement(By.name("lastname")).sendKeys("TesterK");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Krithika@gmail.com");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Yellow12#");

		WebElement option = driver.findElement(By.id("day"));
		Select opt1 = new Select(option);
		opt1.selectByIndex(5);
		WebElement option2 = driver.findElement(By.id("month"));
		Select opt2 = new Select(option2);
		opt2.selectByIndex(3);
		WebElement option3 = driver.findElement(By.id("year"));
		Select opt3 = new Select(option3);
		opt3.selectByValue("1995");
		// driver.findElement(By.xpath("//input[@type='radio'])[1]")).click();
		// By.xpath("//input[@name='sex' and @value='1']")
		driver.findElement(By.xpath("//input[@type='radio' and @value='1']")).click();
		driver.findElement(By.linkText("Sign up")).click();
		System.out.println("the title is " + driver.getTitle());
		driver.close();

	}

}
