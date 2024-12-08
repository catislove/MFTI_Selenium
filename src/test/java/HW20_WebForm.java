import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;


import java.io.File;
import java.io.IOException;
import java.net.URL;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HW20_WebForm {
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
    void fillingForm() throws InterruptedException, IOException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        WebElement textInput = driver.findElement(By.id("my-text-id"));
        textInput.sendKeys("Text input");
        assertEquals("Text input", textInput.getAttribute("value"));

        WebElement password = driver.findElement(By.name("my-password"));
        password.sendKeys("Password");
        assertEquals("Password", password.getAttribute("value"));

        WebElement textarea = driver.findElement(By.name("my-textarea"));
        textarea.sendKeys("Textarea");
        assertEquals("Textarea", textarea.getAttribute("value"));

        WebElement disabledInput = driver.findElement(By.name("my-disabled"));
        assertEquals("", disabledInput.getText());
        Exception thrown = assertThrows(ElementNotInteractableException.class, () -> disabledInput.sendKeys("Test\n"));
        assertThat(thrown.getMessage()).contains("element not interactable");

        WebElement readonlyInput = driver.findElement(By.name("my-readonly"));
        assertEquals("Readonly input", readonlyInput.getAttribute("value"));

        WebElement dropdownSelect = driver.findElement(By.xpath("//select[@name='my-select']/option[@value='2']"));
        dropdownSelect.click();
        assertEquals("2", dropdownSelect.getAttribute("value"));

        WebElement dropdownDatalist = driver.findElement(By.name("my-datalist"));
        dropdownDatalist.sendKeys("San Francisco");
        assertEquals("San Francisco", dropdownDatalist.getAttribute("value"));

        String filePath = "src/test/resources/text.txt";
        URL url = HW20_WebForm.class.getClassLoader().getResource("text.txt");
        String absolutePath = null;
        if (url != null) {
            absolutePath = new File(url.getPath()).getAbsolutePath();
            System.out.println("Абсолютный путь к файлу: " + absolutePath);
        } else {
            System.out.println("Ресурс не найден.");
        }
        WebElement fileUpload = driver.findElement(By.name("my-file"));
        fileUpload.sendKeys(absolutePath);

        WebElement checkedCheckbox = driver.findElement(By.id("my-check-1"));
        checkedCheckbox.click();
        WebElement defaultCheckbox = driver.findElement(By.id("my-check-2"));


        WebElement checkedRadio = driver.findElement(By.id("my-radio-1"));
        WebElement defaultRadio = driver.findElement(By.id("my-radio-2"));

        WebElement colorPicker = driver.findElement(By.name("my-colors"));
        colorPicker.sendKeys("#ff0000");
        assertEquals("#ff0000", colorPicker.getAttribute("value"));

        WebElement dataPicker = driver.findElement(By.name("my-date"));
        dataPicker.sendKeys("11/25/2024");
        assertEquals("11/25/2024", dataPicker.getAttribute("value"));

        WebElement exampleRange = driver.findElement(By.name("my-range"));
        exampleRange.sendKeys("5");
        assertEquals("5", exampleRange.getAttribute("value"));

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();
        assertEquals("Form submitted", driver.findElement(By.cssSelector("h1.display-6")).getText());
    }
}
