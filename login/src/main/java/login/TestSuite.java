package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSuite {
    WebDriver driver; // Class-level driver variable
    
    @BeforeTest
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(); // Initialize the class-level driver
        
        driver.get("https://www.saucedemo.com");	
    }
    
    @Test
    public void login() {
        // Your login test code here...
        WebElement username = driver.findElement(By.name("user-name"));
        username.sendKeys("locked_out_user");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("secret_sauce");
        
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();
    }
    
    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}


