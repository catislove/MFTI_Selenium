import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.HW24_AllureSteps;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@Story("Download")
class HW24_Download{
    WebDriver driver;
    HW24_AllureSteps allureSteps = new HW24_AllureSteps();

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @AfterEach
    void cleanup() {
        deleteFile("downloads/webdrivermanager.png");
        deleteFile("downloads/webdrivermanager.pdf");
        deleteFile("downloads/jupiter.png");
        deleteFile("downloads/jupiter.pdf");
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

    @Test
    void testDownloadHttpClient() throws IOException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/download.html");

        WebElement pngLink = driver.findElement(By.xpath("//a[@download='webdrivermanager.png']"));
        File pngFile = new File("downloads/webdrivermanager.png");
        allureSteps.download(pngLink.getAttribute("href"), pngFile);
        assertThat(pngFile).exists();

        WebElement pdfLink = driver.findElement(By.xpath("//a[@download='webdrivermanager.pdf']"));
        File pdfFile = new File("downloads/webdrivermanager.pdf");
        allureSteps.download(pdfLink.getAttribute("href"), pdfFile);
        assertThat(pdfFile).exists();

        WebElement jupiterLogoLink= driver.findElement(By.xpath("//a[@download='selenium-jupiter.png']"));
        File jupiterLogo = new File("downloads/jupiter.png");
        allureSteps.download(jupiterLogoLink.getAttribute("href"), jupiterLogo);
        assertThat(jupiterLogo).exists();

        WebElement jupiterDocLink= driver.findElement(By.xpath("//a[@download='selenium-jupiter.pdf']"));
        File jupiterDoc = new File("downloads/jupiter.pdf");
        allureSteps.download(jupiterDocLink.getAttribute("href"), jupiterDoc);
        assertThat(jupiterDoc).exists();
    }
}