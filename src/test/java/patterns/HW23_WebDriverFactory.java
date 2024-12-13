package patterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HW23_WebDriverFactory {
    public static WebDriver createWebDriver(String browser) {
        WebDriver driver = switch (browser.toLowerCase()) {
            case "chrome" -> new ChromeDriver();
            case "edge" -> new EdgeDriver();
            case "firefox" -> new FirefoxDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };
        driver.manage().window().maximize();
        return driver;
    }
}
