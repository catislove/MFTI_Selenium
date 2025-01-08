package steps;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class HW24_BaseSteps {
    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    void cleanup() {
        deleteFile("downloads/webdrivermanager.png");
        deleteFile("downloads/webdrivermanager.pdf");
    }

    private void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            boolean deleted = file.delete();
            if (!deleted) {
                System.err.println("Failed to delete file: " + filePath);
            }
        }
    }
}
