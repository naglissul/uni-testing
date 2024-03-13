package mifasaLab1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstTestClass {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Naglis\\OneDrive\\CURR_STUFF\\mifas\\testoing\\chromedriver.exe");
		
	    ChromeOptions options = new ChromeOptions();
	        
	    options.addArguments("--ignore-certificate-errors");
		
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com");
		//Web element find
		driver.findElement(By.xpath("//a[@href='/gift-cards']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Gift Card') and number(substring-after(substring-before(.,' '),'$')) > 99]")).click();
		driver.findElement(By.className("recipient-name")).sendKeys("Hello world");
		driver.findElement(By.className("sender-name")).sendKeys("Lorem ipsum");
		driver.findElement(By.className("qty-input")).clear();
		driver.findElement(By.className("qty-input")).sendKeys("5000");
		driver.findElement(By.id("add-to-cart-button-4")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("add-to-wishlist-button-4")).click();
		driver.findElement(By.xpath("//a[@href='/jewelry']")).click();
		driver.findElement(By.xpath("//a[@href='/create-it-yourself-jewelry']")).click();
		driver.findElement(By.xpath("//select[@id='product_attribute_71_9_15']")).sendKeys("Silver (1 mm)");
		
		driver.findElement(By.id("product_attribute_71_10_16")).sendKeys("80");
		driver.findElement(By.id("product_attribute_71_11_17_50")).click();
		driver.findElement(By.id("addtocart_71_EnteredQuantity")).clear();
		driver.findElement(By.id("addtocart_71_EnteredQuantity")).sendKeys("26");
		driver.findElement(By.id("add-to-cart-button-71")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("add-to-wishlist-button-71")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='/wishlist']")).click();
		driver.findElement(By.xpath("(//input[@name='addtocart'])[1]")).click();
		driver.findElement(By.xpath("(//input[@name='addtocart'])[2]")).click();
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		assert driver.findElement(By.xpath("//span[@class='product-price' and contains(.,'1002600.00')]")) != null;
		driver.close();
	}
}
