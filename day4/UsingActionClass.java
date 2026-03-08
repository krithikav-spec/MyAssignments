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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


@SuppressWarnings("unused")
public class UsingActionClass  {

	public static Actions actions;

	public static void main(String[] args) throws IOException  {
		
		ChromeDriver driver = new ChromeDriver();
        // Load URL	
        driver.get("https://www.amazon.in/");
        // Maximize window
        driver.manage().window().maximize();
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement element1= driver.findElement(By.linkText("Conditions of Use & Sale"));
        
        
        Actions act= new Actions(driver);
        act.scrollToElement(element1).perform();
        
        String text = element1.getText();
        System.out.println("Text found: " + text);
        
        File source= element1.getScreenshotAs(OutputType.FILE);
        File destination= new File("./data/Amazon.png");
        FileUtils.copyFile(source, destination);
        driver.close();
    }
  }


