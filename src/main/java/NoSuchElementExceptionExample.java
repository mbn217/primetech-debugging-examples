import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchElementExceptionExample {


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");
        driver.findElement(By.id("nonexistent-id")).click(); // This will throw a NoSuchElementException

    }
}


/**
 * Issue:
 *
 * The element with the ID nonexistent-id doesn’t exist on the page, so Selenium throws a NoSuchElementException.
 *
 * Fix:
 *
 * Double-check the element locator (ID, XPath, etc.) and ensure the element exists on the page.
 *
 * Use explicit waits to wait for the element to appear.
 *
 * WebDriverWait wait = new WebDriverWait(driver, 10);
 * wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nonexistent-id"))).click();
 *
 *
 */