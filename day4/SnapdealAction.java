package week5.day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

@SuppressWarnings("unused")
public class SnapdealAction {
	public static Actions actions;

	public static void main(String[] args) throws IOException, InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		// Load URL
		driver.get("https://www.snapdeal.com/");
		// Maximize window
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions act = new Actions(driver);
		// 2.scroll to the mens fashion
		WebElement mensFashion = driver.findElement(By.xpath("//div[text()=\"Men's Fashion\"]"));
		act.scrollToElement(mensFashion).moveToElement(mensFashion).perform();
		Thread.sleep(3000);
		// 3. Go to Sports Shoes
		WebElement sportsShoes = driver.findElement(
				By.xpath("//div[text()=\"Men's Fashion\"]/following-sibling::div//div[text()='Sports Shoes']"));
		sportsShoes.click();
		// 4.Get the count of sports shoes and print them
		WebElement shoesList = driver.findElement(By.xpath("//span[contains(@class,'category-count')]"));
		String ShoeList = shoesList.getText();
		System.out.println("Sports Shoes count: " + ShoeList);
		// 5.Click on "Training Shoes".
		driver.findElement(By.xpath("//a[div[text()='Training Shoes']]")).click();
		// sort
		driver.findElement(By.xpath("//div[contains(@class,'sort-drop')]")).click();

		// 6. Sort the products by "Low to High".
		driver.findElement(By.xpath("//ul[contains(@class,'sort-value')]//li[normalize-space()='Price Low To High']"))
				.click();
		// 7.Select any price range ex:(500-700).
		WebElement fromValue = driver.findElement(By.name("fromVal"));
		fromValue.clear();
		fromValue.sendKeys("400");
		WebElement toVal = driver.findElement(By.name("toVal"));
		toVal.clear();
		toVal.sendKeys("800");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@data-filtername='Color_s']//label[a[normalize-space()='White & Blue']]")).click();
		//8. Mouse hover on the first resulting "Training Shoes".
				WebElement shoe = driver.findElement(By
						.xpath("//div[contains(@class,'product-tuple-listing')]//div[contains(@class,'product-tuple-image')]"));
				Thread.sleep(3000);
				act.scrollToElement(shoe).moveToElement(shoe).perform();
				//Thread.sleep(3000);
	// 9.Click the "Quick View" button.
				driver.findElement(By.xpath("//div[contains(@class,'quick-view-bar')]")).click();
				
	//10. Print the cost and the discount percentage.
	WebElement marketPrice = driver
						.findElement(By.xpath(
								"//div[contains(@class,'quickProductDescPanel')]//div[contains(@class,'product-desc-price')]"));
	String marketPrice1= marketPrice.getText();

	WebElement discountPrice = driver
						.findElement(By.xpath(
								"//div[contains(@class,'quickProductDescPanel')]//div[contains(@class,'product-price')]"));
	String discountPrice1=discountPrice.getText();
				System.out.println("marketPrice-"+marketPrice1);
				System.out.println("discountPrice-"+discountPrice1);
				
				//screenshot
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest = new File("./data/snapDeal.png");
				FileUtils.copyFile(src, dest);
				System.out.println("Screenshot captured sucessfully");


				driver.quit();


		//
	}
}