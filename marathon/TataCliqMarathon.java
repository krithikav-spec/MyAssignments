package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("unused")

public class TataCliqMarathon {
	public static Actions actions;

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		// Load URL
		driver.get("https://www.tatacliq.com/");
		// Maximize window
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions act = new Actions(driver);
		// sweet alert- so get the webelement of it and click
		Thread.sleep(3000);
		WebElement alert = driver.findElement(By.xpath("//button[@id='moe-dontallow_button']"));
		alert.click();
		WebElement brandMain = driver.findElement(By.xpath("//div[normalize-space()='Brands']"));
		act.moveToElement(brandMain).perform();
		// watches
		WebElement watchesMenu = driver
				.findElement(By.xpath("//div[@role='button' and text()='Watches & Accessories']"));
		act.moveToElement(watchesMenu).perform();
		Thread.sleep(3000);
		// click on first featured brand
		WebElement firstFeaturedBrand = driver.findElement(
				By.xpath("//div[contains(@class,'brandsHeader') and text()='Featured brands']/following-sibling::div"));
		firstFeaturedBrand.click();
		Thread.sleep(3000);
		// sort - dropdown-
		Select selectOptions = new Select(driver.findElement(By.tagName("select")));
		selectOptions.selectByVisibleText("New Arrivals");
		Thread.sleep(3000);

		// Choose men from categories filter
		WebElement menCategory = driver
				.findElement(By.xpath("//div[@id='accordion-panel-Category']//div[@role='radio']"));
		menCategory.click();

		Thread.sleep(3000);

		// Print all prices of watches
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		System.out.println("Prices of watches:");
		String firstPrice = prices.get(0).getText();
		for (WebElement price : prices) {
			System.out.println(price.getText());
		}
		// Click on the first resulting watch
		WebElement firstWatch = driver.findElement(By.xpath("//div[@class='ProductModule__dummyDiv']"));
		firstWatch.click();
		Thread.sleep(3000);
		// Switch to new tab if opened
		Set<String> openedWindowIDs = driver.getWindowHandles();
		List<String> openedWindowIDsList = new ArrayList<>(openedWindowIDs);
		driver.switchTo().window(openedWindowIDsList.get(1));

		// Compare two prices are similar
		WebElement productPrice = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']//h3"));
		String productPrice1 = productPrice.getText().replace("MRP:  ₹", "");
		// WebElement offerPrice =
		// driver.findElement(By.xpath("//span[@class='pdpSellingPrice']"));
		// String offerprice2 = productPrice.getText().replace("MRP: ", "");

		if (productPrice1.contains(firstPrice)) {
			System.out.println("Prices are similar.");
		} else {
			System.out.println("Prices are different.");
		}

		// Click Add to cart and get count from cart icon
		WebElement addToCart = driver
				.findElement(By.xpath("//div[@class='Button__base' and span[text()='ADD TO BAG']]"));
		addToCart.click();
		Thread.sleep(3000);

		// Click on the cart

		WebElement cartIcon = driver.findElement(By.xpath("//div[span[@class='DesktopHeader__cartCount']]"));
		cartIcon.click();
		Thread.sleep(3000);

		// Take a snap of the resulting page

		TakesScreenshot ts = (TakesScreenshot)driver;
		File src1 = ts.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./data/cart_1.png");
		FileUtils.copyFile(src1, dest1);
		System.out.println("Screenshot captured sucessfully");

		driver.quit();

	}

}
