import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HW21_Dropdown {

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
    void dropdownTest() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");

        WebElement dropdown1 = driver.findElement(By.id("my-dropdown-1"));
        new Actions(driver)
                .click(dropdown1)
                .perform();

        WebElement dropdown2 = driver.findElement(By.id("my-dropdown-2"));
        new Actions(driver)
                .contextClick(dropdown2)
                .perform();

        WebElement dropdown3 = driver.findElement(By.id("my-dropdown-3"));
        new Actions(driver)
                .doubleClick(dropdown3)
                .perform();
    }
}
