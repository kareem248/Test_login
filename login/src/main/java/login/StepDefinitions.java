package login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After; // Import the After annotation
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {
    WebDriver driver; // Declare a WebDriver instance to interact with the browser

    @Given("I am on the SauceDemo login page")
    public void i_am_on_the_saucedemo_login_page() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com");
    }

    @When("I enter my username and password")
    public void i_enter_my_username_and_password() {
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    // Implement other step methods for your scenarios...

    @Then("I should be on the inventory page")
    public void i_should_be_on_the_inventory_page() {
        // You can add assertions here to verify that you are on the inventory page
        // For example, you can check the current URL or page title
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.equals(expectedURL)) {
            System.out.println("On the inventory page.");
        } else {
            System.out.println("Not on the inventory page.");
        }
    }

    @Then("I should see a successful purchase message")
    public void i_should_see_a_successful_purchase_message() {
        // You can add assertions here to verify the successful purchase message
        WebElement successMessage = driver.findElement(By.id("checkout_complete_container"));

        if (successMessage.isDisplayed()) {
            System.out.println("Successful purchase message is displayed.");
        } else {
            System.out.println("Successful purchase message is not displayed.");
        }
    }

    // Add the @After hook to close the WebDriver
    @After
    public void closeBrowser() {
        driver.quit();
    }
}
