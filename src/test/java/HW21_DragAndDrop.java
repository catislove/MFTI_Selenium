import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HW21_DragAndDrop {
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
    void dragAndDropTest(){
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("target"));
        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();
    }
}
