package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Logink {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com");
        Thread.sleep(3000);

        
        WebElement emailInput = driver.findElement(By.id("user-name"));
        emailInput.sendKeys("standard_user");
        
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(2000);

        
        // Check if the login was successful
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
            // Successfully logged in, now proceed with other steps
            
            // Add products to the cart
            driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
            driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
            driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
            driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
            
            Thread.sleep(2000);

            
            // View the Cart and checkout
            driver.findElement(By.id("shopping_cart_container")).click();
            driver.findElement(By.id("checkout")).click();
            Thread.sleep(3000);

            
            // Shipping Information
            driver.findElement(By.id("first-name")).sendKeys("kareem");
            driver.findElement(By.id("last-name")).sendKeys("elshafey");
            driver.findElement(By.id("postal-code")).sendKeys("12345");
            
            Thread.sleep(3000);

            
            driver.findElement(By.id("continue")).click();
            driver.findElement(By.id("finish")).click();
            
            Thread.sleep(2000);

            
            boolean isPurchaseSuccessful = driver.findElement(By.id("checkout_complete_container")).isDisplayed();
            
            if (isPurchaseSuccessful) {
                System.out.println("Purchase Success");
            } else {
                System.out.println("Purchase Fail");
            }
        } else {
            // Login failed, handle the error or print a message
            System.out.println("Login failed. Please check your credentials.");
        }
        
        Thread.sleep(4000);
        
        driver.quit();
    }
}



