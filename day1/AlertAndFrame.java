package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("unused")
public class AlertAndFrame {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		// open the required link
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame("iframeResult");
		//click on the tryit button on the frame
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert1= driver.switchTo().alert();
		System.out.println("printing the text displayed within the alert-" +alert1.getText());
		//click ok/cancel on the alert- selecting cancel
		alert1.dismiss();
		WebElement result1 = driver.findElement(By.id("demo"));
		String resultSel = result1.getText();
		
	if (resultSel.contains(" OK!")) {
		System.out.println("option selected was OK");}
		else {
			System.out.println("option selected was CANCEL");
		}
	}
}	
		
//
	


