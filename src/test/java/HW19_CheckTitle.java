import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HW19_CheckTitle {

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
    void openSiteTest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        assertEquals("Hands-On Selenium WebDriver with Java", driver.getTitle());
    }
}
