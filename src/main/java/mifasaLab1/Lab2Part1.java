package mifasaLab1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lab2Part1 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Naglis\\OneDrive\\CURR_STUFF\\mifas\\testoing\\chromedriver.exe");
		
	    ChromeOptions options = new ChromeOptions();
	        
	    options.addArguments("--ignore-certificate-errors");
		
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		//Web element find
		
		//scroll
		//		driver.findElement(By.xpath("//div[contains(@class, 'top-card')/node()[. ='Widgets']")).click();
		driver.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(By.xpath("//h5[text()='Widgets']")).click();
		
		driver.findElement(By.xpath("//span[text()='Progress Bar']")).click();
		driver.findElement(By.xpath("//button[@id='startStopButton' and text()='Start']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='100%' and @role='progressbar']")));
		driver.findElement(By.xpath("//button[@id='resetButton']")).click();
		driver.findElement(By.xpath("//div[text()='0%' and @role='progressbar']"));
		System.out.println("Found bar with 0%");
		
		driver.quit();
	}
}
