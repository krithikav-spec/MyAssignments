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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@SuppressWarnings("unused")
public class RedBusAutomation {

	public static void main(String[] args) throws InterruptedException {
		// 1. Launch the browser
		ChromeDriver driver = new ChromeDriver();

		// 2. Navigate to RedBus
		driver.get("https://www.redbus.in/");

		// 3. Maximize the browser window
		driver.manage().window().maximize();

		// 4. Select From city
		driver.findElement(By.xpath("//input[@id='srcinput']")).sendKeys("Chennai");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		// 5. Select to city
		driver.findElement(By.xpath("//input[@id='destinput']")).sendKeys("Salem");
		driver.findElement(By.xpath("//div[text()='Salem']")).click();
		// select date
		WebElement DatePickr = driver.findElement(By.xpath("//div[@role='combobox']"));
		DatePickr.click();
		WebElement DateSelected = driver.findElement(By.xpath("//div[@data-datetype='AVAILABLE']//span"));
		driver.executeScript("arguments[0].click();", DateSelected);
		// CLick Search
		driver.findElement(By.xpath("//button[@aria-label='Search buses']")).click();
		// Print the Total number of buss displayed
		String totalBus = driver.findElement(By.xpath("//div[contains(@class,'busesFoundText')]")).getText();
		System.out.println("Total number of Buses Displayed are " + totalBus);
		// Select AC FIlter
		driver.findElement(By.xpath("//div[contains(@class,'mainContainer')]//div[contains(text(),'AC')]")).click();
		Thread.sleep(1000);
		String count = driver
				.findElement(By.xpath("//div[contains(@class,'textContainer')]//span[contains(@class,'subtitle')]"))
				.getText();
		System.out.println("Count after AC filter:" + count);

		// select Bus count after High Rate filter
		driver.findElement(
				By.xpath("//div[contains(@class,'mainContainer')]//div[contains(text(),'High Rated Buses')]")).click();
		Thread.sleep(1000);
		String count1 = driver
				.findElement(By.xpath("//div[contains(@class,'textContainer')]//span[contains(@class,'subtitle')]"))
				.getText();
		System.out.println("Count after High Rated filter:" + count1);
		// Get the list of prices

		List<WebElement> priceElements = driver.findElements(By.xpath("//p[contains(@class,'finalFare')]"));
		List<Integer> prices = new ArrayList<>();
		
		// Identify and print the lowest bus price.
		for (WebElement e : priceElements) {
			int price = Integer.parseInt(e.getText().replaceAll("[^0-9]", ""));
			prices.add(price);
		}

		prices.sort(null);

		System.out.println("Lowest price:" + prices.get(0));

		System.out.println("the Page Title is" + driver.getTitle());
		driver.close();

	}
}
