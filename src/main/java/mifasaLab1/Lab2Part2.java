package mifasaLab1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lab2Part2 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Naglis\\OneDrive\\CURR_STUFF\\mifas\\testoing\\chromedriver.exe");
		
	    ChromeOptions options = new ChromeOptions();
	        
	    options.addArguments("--ignore-certificate-errors");
		
		
		ChromeDriver driver = new ChromeDriver(options);
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		//Web element find
		driver.executeScript("window.scrollBy(0,100)", "");
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Elements']")));
		
		driver.findElement(By.xpath("//h5[text()='Elements']")).click();
		//driver.executeScript("document.body.style.zoom = '50%'");

		driver.findElement(By.xpath("//span[text()='Web Tables']")).click();

		while (driver.findElement(By.xpath("//span[@class='-totalPages']")).getText().equals("1")) {
			driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();

	        // find the fields by their IDs and fill them with 'a' for testing
	        driver.findElement(By.id("firstName")).sendKeys("a");
	        driver.findElement(By.id("lastName")).sendKeys("a");
	        driver.findElement(By.id("userEmail")).sendKeys("a@a.com");
	        driver.findElement(By.id("age")).sendKeys("1");
	        driver.findElement(By.id("salary")).sendKeys("1");
	        driver.findElement(By.id("department")).sendKeys("a");

	        // Submit the form
	       
	        driver.findElement(By.id("submit")).click();

	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='-totalPages']")));
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='-btn' and text()='Next']")));
        driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='Next']")));
		driver.executeScript("window.scrollBy(0,100)", "");

		driver.findElement(By.xpath("//span[@id='delete-record-11']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@aria-label='jump to page']")).getAttribute("value").equals("1"));
		System.out.println(driver.findElement(By.xpath("//span[@class='-totalPages']")).getText().equals("1"));
//website bug. 2 out of 1 says...

		//driver.close();
	}
}
