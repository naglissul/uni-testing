package mifasaLab1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Lab3OrAsCalledTask4OrAsCalledPart4 {
    private WebDriver driver;
    private final String email = "testuser6649806@example.com";
    private final String password = "Password123";
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Naglis\\OneDrive\\CURR_STUFF\\mifas\\testoing\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    
    @Test
    public void userRegistration() {
        driver.get("https://demowebshop.tricentis.com/");

      driver.findElement(By.linkText("Register")).click();
      driver.findElement(By.id("gender-male")).click();
      driver.findElement(By.id("FirstName")).sendKeys("John");
      driver.findElement(By.id("LastName")).sendKeys("Doe");
      driver.findElement(By.id("Email")).sendKeys(email);
      driver.findElement(By.id("Password")).sendKeys(password);
      driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
      driver.findElement(By.id("register-button")).click();
          
      Assert.assertNotNull(driver.findElement(By.xpath("//div[contains(text(), 'registration completed')]")));
    }
    
    @Test
    public void firstTest() throws InterruptedException, IOException {
        driver.get("https://demowebshop.tricentis.com/");

        // Login
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
        
        // Test execution
        addProductsToCart("data1.txt");
        
        // Checkout
        completeCheckout();
    }
    
    @Test
    public void secondTest() throws InterruptedException, IOException {
        driver.get("https://demowebshop.tricentis.com/");

        // Login
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Log in']")).click();        
        // Test execution
        addProductsToCart("data2.txt");
        
        // Checkout
        completeCheckout();
    }
    
    private void addProductsToCart(String dataFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(dataFile));
        String productName;
        while ((productName = reader.readLine()) != null) {
        	System.out.println(productName);
            driver.findElement(By.linkText("Digital downloads")).click();
            driver.findElement(By.linkText(productName)).click();
            driver.findElement(By.cssSelector("input[value='Add to cart']")).click();
        }
        reader.close();
    }
    
    private void completeCheckout() throws InterruptedException {
        driver.findElement(By.linkText("Shopping cart")).click();
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();
     // Fill in the billing information
     // Check if the billing address is already selected
        boolean isAddressPresent = driver.findElements(By.id("billing-address-select")).size() > 0;

        if(isAddressPresent) {
            // If the dropdown for the billing address exists, assume the address is already selected
            driver.findElement(By.cssSelector("input[title='Continue']")).click();
        } else {
        	//these are prefilled:
//          driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("John");
//          driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Doe");
//          driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("testuser69@example.com");
          new Select(driver.findElement(By.id("BillingNewAddress_CountryId"))).selectByVisibleText("Albania");
          driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Anytown");
          driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("123 Main St");
          driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("12345");
          driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("1234567890");
          driver.findElement(By.cssSelector("input[title='Continue']")).click();
        }
        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".payment-method-next-step-button")));
        driver.findElement(By.cssSelector(".payment-method-next-step-button")).click();
        
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".payment-info-next-step-button")));
        driver.findElement(By.cssSelector(".payment-info-next-step-button")).click();
        
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".confirm-order-next-step-button")));
        driver.findElement(By.cssSelector(".confirm-order-next-step-button")).click();

        Thread.sleep(2000);
        Assert.assertNotNull(driver.findElement(By.xpath("//strong[contains(text(), 'Your order has been successfully processed!')]")));
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
}
