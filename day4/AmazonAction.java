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
public class AmazonAction {
	public static Actions actions;

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		// Load URL
		driver.get("https://www.amazon.in/");
		// Maximize window
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions act = new Actions(driver);
		// identify search tab and assign a webelement-searchElement
		WebElement searchElement = driver.findElement(By.id("twotabsearchtextbox"));
		// hover to the search tab , click , enter searchdata
		act.moveToElement(searchElement).click().sendKeys("oneplus 9 pro").perform();
		// click on search button
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		// to fetch the price of the first element and print it
		WebElement priceElement = driver.findElement(By.xpath("//span[normalize-space()='148']"));
		String price = priceElement.getText();
		System.out.println("Price of the first item is - " + price);
		// to fetch the ratings of that product and print it
		WebElement ratingElement = driver.findElement(By.xpath(
				"//span[@class='a-size-mini puis-normal-weight-text s-underline-text'][normalize-space()='(4.8K)']"));
		String rating = ratingElement.getText();
		System.out.println("rating of the first item is - " + rating);

		// click on the first product image
		WebElement firstProduct = driver.findElement(By.xpath(
				"//img[@alt='JGD PRODUCTS for OnePlus 9 Pro Premium Transparent Hybrid Soft Slim Dust Proof Plastic Back Case Cover with Camera Protection']"));
		act.moveToElement(firstProduct).click().perform();
		// move the driver focus to the product page
		Set<String> parentWindow = driver.getWindowHandles();
		List<String> childWindow = new ArrayList<String>(parentWindow);
		driver.switchTo().window(childWindow.get(1));

		// capture screenshot of product page
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./data/product_screenshot.png");
		FileUtils.copyFile(src, dest);
		System.out.println("Screenshot captured sucessfully");

		// add product to cart
		WebElement addCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		act.moveToElement(addCart).click().perform();

		// verify the cart subtotal
		WebElement cartTotal = driver.findElement(By.xpath("//span[@class='a-price sw-subtotal-amount']"));
		String cartTotal1 = cartTotal.getText();
		System.out.println("cart total - " + cartTotal1);

		if (cartTotal1.contains(price)) {
			System.out.println("the product is ADDED sucessfully");
		} else {
			System.out.println("the product was NOT added");
		}
		driver.quit();
	}
}
