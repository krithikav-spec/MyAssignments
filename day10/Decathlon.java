package week3.day10;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@SuppressWarnings("unused")

public class Decathlon {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		;
		ChromeDriver driver = new ChromeDriver(opt);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// get the decathlon link
		driver.get("https://www.decathlon.in/");
		// maximize window
		driver.manage().window().maximize();
		// click on search tab
		driver.findElement(By.xpath("//span[@class='index-module_type__E-SaG']")).click();
		// Enter the product name “Shoes”
		driver.findElement(By.xpath("//span[@class='index-module_type__E-SaG']/preceding::input")).sendKeys("Shoes",
				Keys.ENTER);
		// Click on the Sport filter
		driver.findElement(By.xpath("//span[contains(text(),'Sport shoes ')]")).click();
		// click on Running from the Sport
		driver.findElement(By.xpath("//span[contains(text(),'Running')]")).click();
		// Click on the Gender filter dropdown-select women
		driver.findElement(By.xpath("//span[contains(text(),'Men ')]")).click();
		// Click on the Sort By dropdown and choose'most relevant'
		driver.findElement(By.xpath("//span[contains(text(),'Most Relevant')]")).click();

		// From the filtered results, click on the first available product
		driver.findElement(By.xpath("//a[text()='Highest Discount']")).click();

		// Selecting the first product

		driver.findElement(By.xpath("//span[@class='text-14 lg:text-16 font-semibold']")).click();

		// selecting size
		driver.findElement(By.xpath("//div[contains(text(),'8.5')]")).click();

		// Add to cart
		Thread.sleep(5000);
		WebElement clickBelow = driver.findElement(By.xpath("//span[text()='ADD TO CART']"));
		driver.executeScript("arguments[0].click();", clickBelow);

		String cartitem = driver.findElement(By.xpath("//a[@aria-label='cart']/div/div/div")).getText();

		int cartNumber = Integer.parseInt(cartitem);

		if (cartNumber > 0) {
			System.out.println("Total " + cartNumber + " in the cart");

		} else {
			System.out.println("No products added in the car");
		}

	}

}