
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SauceDemoLoginTestArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Navigate to the Sauce Demo login page
            driver.get("https://www.saucedemo.com");

            // Log in with valid credentials
            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));
            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Wait for the inventory page to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));

            // Get all product names from the inventory page
            List<WebElement> productElements = driver.findElements(By.className("inventory_item_name"));
            String[] productNames = new String[3]; // Intentional error: Array size is too small

            // Store product names in the array
            for (int i = 0; i < productElements.size(); i++) {
                productNames[i] = productElements.get(i).getText(); // Error: ArrayIndexOutOfBoundsException
            }

            // Print the product names
            System.out.println("Product Names:");
            for (String name : productNames) {
                System.out.println(name);
            }
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
 * ArrayIndexOutOfBoundsException:
 *
 * The array productNames is initialized with a size of 3, but the number of products on the Sauce Demo inventory page is 6. When the loop tries to store the 4th product name, it throws an ArrayIndexOutOfBoundsException because the array size is exceeded.
 *
 * How to Debug
 * Read the Exception Message:
 *
 * When the code runs, it will throw an ArrayIndexOutOfBoundsException and print the exception message:
 *
 *
 * An exception occurred: Index 3 out of bounds for length 3
 * This tells you that the array size is too small to hold all the product names.
 *
 * Fix the Issue:
 *
 * Initialize the array with the correct size based on the number of products. Use productElements.size() to dynamically set the array size:
 * String[] productNames = new String[productElements.size()];
 *
 *
 * Add Debugging Clues:
 *
 * Print the number of products before initializing the array to ensure the array size is correct:
 * System.out.println("Number of products: " + productElements.size());
 *
 * Key Takeaways
 * ArrayIndexOutOfBoundsException occurs when you try to access or store data in an array index that doesn’t exist.
 *
 * Always ensure the array size matches the number of elements you’re working with.
 *
 * Use dynamic sizing (e.g., productElements.size()) to avoid hardcoding array sizes.
 *
 * Add debugging clues like printing the number of elements to verify your logic.
 */