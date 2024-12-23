package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import patterns.HW23_WebDriverFactory;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class HW23_BasePage {
    static final Logger log = getLogger(lookup().lookupClass());

    WebDriver driver;
    WebDriverWait wait;
    int timeoutSec = 5;

    public HW23_BasePage(String browser) {
        driver = HW23_WebDriverFactory.createWebDriver(browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
    }

    public HW23_BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
    }

    public void setTimeoutSec(int timeoutSec) {
        this.timeoutSec = timeoutSec;
    }

    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebElement find(By element) {
        return driver.findElement(element);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void click(By element) {
        click(find(element));
    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void type(By element, String text) {
        type(find(element), text);
    }

    public boolean isDisplayed(WebElement element) {
        return isDisplayed(ExpectedConditions.visibilityOf(element));
    }

    public boolean isDisplayed(By locator) {
        return isDisplayed(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isDisplayed(ExpectedCondition<?> expectedCondition) {
        try {
            wait.until(expectedCondition);
        } catch (TimeoutException e) {
            log.warn("Timeout of {} wait for element ", timeoutSec);
            return false;
        }
        return true;
    }

    public boolean isEnabled(WebElement element) {
        try {
            return wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver driver) {
                    return element.isEnabled();
                }
            });
        } catch (TimeoutException e) {
            log.warn("Timeout of {} seconds while waiting for button to be enabled", timeoutSec);
            return false;
        }
    }

    public void fileUpload (WebElement element, String filePath){
    URL url = HW23_WebFormPage.class.getClassLoader().getResource("text.txt");
    String absolutePath = null;
        if (url != null) {
        absolutePath = new File(url.getPath()).getAbsolutePath();
        System.out.println("Абсолютный путь к файлу: " + absolutePath);
    } else {
        System.out.println("Ресурс не найден.");
    }
        element.sendKeys(absolutePath);
    }
}
