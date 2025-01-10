
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SauceDemoLoginTestNoSuchElementException {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Navigate to the Sauce Demo login page
            driver.get("https://www.saucedemo.com");

            // Find the username and password fields
            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));

            // Enter valid credentials
            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");

            // Click the login button
            WebElement loginButton = driver.findElement(By.id("login-button"));
            loginButton.click();

            // Wait for the inventory page to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));

            // Verify login success by checking the page title
            String pageTitle = driver.findElement(By.className("title")).getText();

            if (pageTitle.equals("Products")) {
                System.out.println("Login test passed! User is on the Products page.");
            } else {
                System.out.println("Login test failed! User is not on the Products page.");
            }

            // Intentional error: Try to find an element that doesn't exist
            WebElement nonExistentElement = driver.findElement(By.id("non-existent-id")); // Error: This will throw NoSuchElementException
            nonExistentElement.click();
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage()); // Debugging clue: This will print the exception message
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}


/**
 *
 * Error in the Code
 * NoSuchElementException:
 *
 * The line WebElement nonExistentElement = driver.findElement(By.id("non-existent-id")); tries to locate an element with the ID non-existent-id, which doesn’t exist on the page. This will throw a NoSuchElementException.
 *
 * How to Debug
 * Read the Exception Message:
 *
 * When the code runs, it will throw a NoSuchElementException and print the exception message:
 *
 *
 * An exception occurred: no such element: Unable to locate element: {"method":"css selector","selector":"#non\-existent\-id"}
 * This tells you that the element with the ID non-existent-id cannot be found.
 *
 * Fix the Issue:
 *
 * Remove or correct the line causing the error. For example, if you were trying to interact with a real element, use the correct locator
 *
 *
 *
 * Key Takeaways
 * NoSuchElementException occurs when Selenium cannot find an element using the specified locator.
 *
 * Always double-check your locators (e.g., ID, class name, XPath) to ensure they match the elements on the page.
 *
 * Use exception handling to catch and debug errors gracefully.
 *
 * Add debugging clues like printing the current URL or page source to understand the state of the application when the error occurs.
 */