package week5.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@SuppressWarnings("unused")
public class WindowHandle {

	public static void main(String[] args) throws InterruptedException{
		ChromeDriver driver= new ChromeDriver();
		//maximize window
				driver.manage().window().maximize();
				// open the required link
				driver.get("https://www.irctc.co.in/");
				//implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.findElement(By.xpath("//button[text()='OK']")).click();
				//selecting flights
				driver.findElement(By.xpath("//label[text()='FLIGHTS']")).click();
				//switching driver focus to child window- flights
				Set<String> parentWindow= driver.getWindowHandles();
				List<String> childWindow = new ArrayList<String>(parentWindow);
				driver.switchTo().window(childWindow.get(1));
				String title1= driver.getTitle();
				System.out.println(title1);
				//driver.close();
				//switching the focus back to parent window
				driver.switchTo().window(childWindow.get(0));
				String title2= driver.getTitle();
				System.out.println(title2);
				//close the current window
				driver.close();
				
	}

}
