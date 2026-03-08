package week5.day4;import java.io.File;
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
	public class BigBasketAction {
	public static Actions actions;
	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		//1. Navigate to https://www.bigbasket.com/.
		driver.get("https://www.bigbasket.com/");
	  	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions act = new Actions(driver);
		//2.Click on "Shop by Category".
		WebElement shopCategory = driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:Ramkj6:']"));
		act.moveToElement(shopCategory).click().perform();
		//3. Mouse over "Foodgrains, Oil & Masala".
		WebElement foodOilGrain = driver.findElement(By.xpath("//li[a[text()='Foodgrains, Oil & Masala' and @role='none']]"));
		act.scrollToElement(foodOilGrain).moveToElement(foodOilGrain).perform();
		//4. Mouse over "Rice & Rice Products".
		WebElement riceProduct = driver.findElement(By.xpath("//li/a[text()='Rice & Rice Products'][1]"));
		act.scrollToElement(riceProduct).moveToElement(riceProduct).perform();
		//5. Click on "Boiled & Steam Rice".
		WebElement boiledRice = driver.findElement(By.xpath("//li/a[text()='Boiled & Steam Rice']"));
		act.scrollToElement(boiledRice).moveToElement(boiledRice).click().perform();
		//6. Filter the results by selecting the brand "bb Royal".
		WebElement bbRoyalCheckbox = driver.findElement(By.id("i-bbRoyal"));
		//Thread.sleep(3000);
        act.scrollToElement(bbRoyalCheckbox).moveToElement(bbRoyalCheckbox).click().perform();
        Thread.sleep(2000);
        //7. Click on "Tamil Ponni Boiled Rice".
        driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']")).click();
        //act.moveToElement(tamilPonni).click().perform();
        //8a)switch the driver focus to the product window 
        Set<String> window1 = driver.getWindowHandles();
		List<String> window2 = new ArrayList<String>(window1);
		driver.switchTo().window(window2.get(1));
		//8. Select the 5 Kg bag.
		WebElement select =driver.findElement(By.xpath("//div[@class='w-full']//div[.//span[text()='5 kg']]"));
		act.scrollToElement(select).moveToElement(select).click();
		//9. Check and note the price of the rice.
		WebElement price1 = driver.findElement(By.xpath("//div[@class='w-full']//div[.//span[text()='5 kg']]"));
		String price=price1.getText();
		System.out.println("price of 5kg ponni rice-"+price);
		//10. Click "Add" to add the bag to your cart.
		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
		//11. Verify the success message that confirms the item was added to your cart.
		WebElement cartQty= driver.findElement(By.xpath("//div[contains(@class,'Toast')]//p"));
		String cartQty1=cartQty.getText();
				
				if (cartQty1.contains("added")) {
					System.out.println("Items not added");}
				else {
					System.out.println("Items added");
				}
				
			//screenshot
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest = new File("./data/bbproduct.png");
				FileUtils.copyFile(src, dest);
				System.out.println("Screenshot captured sucessfully");


				driver.quit();

			}
		
	}

