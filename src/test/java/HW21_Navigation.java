import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HW21_Navigation {
    WebDriver driver;

    @BeforeEach
    void init() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void close() {
        driver.close();
    }

    @Test
    void navigationForm() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/navigation1.html");

        WebElement previousButton = driver.findElement(By.xpath("//a[contains(text(), 'Previous')]"));
        WebElement page1 = driver.findElement(By.xpath("//a[@href='navigation1.html']"));
        page1.click();
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", driver.findElement(By.xpath("//p[@class='lead']")).getText());
        Exception thrown = assertThrows(StaleElementReferenceException.class, () -> previousButton.click());
        assertThat(thrown.getMessage()).contains("stale element not found");

        WebElement page2 = driver.findElement(By.xpath("//a[@href='navigation2.html']"));
        page2.click();
        assertEquals("Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.", driver.findElement(By.xpath("//p[@class='lead']")).getText());

        WebElement nextButton = driver.findElement(By.xpath("//a[contains(text(), 'Next')]"));
        WebElement page3 = driver.findElement(By.xpath("//a[@href='navigation3.html']"));
        page3.click();
        assertEquals("Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", driver.findElement(By.xpath("//p[@class='lead']")).getText());
        Exception thrown1 = assertThrows(StaleElementReferenceException.class, () -> nextButton.click());
        assertThat(thrown1.getMessage()).contains("stale element not found");
    }
}
