package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HW23_FooterComponent {

    private WebDriver driver;

    @FindBy(className = "text-muted")
    @CacheLookup
    private WebElement copyright;

    @FindBy(xpath = "//a[@href='https://bonigarcia.dev/']")
    @CacheLookup
    private WebElement copyrightLink;

    public HW23_FooterComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCopyrightText() {
        return copyright.getText();
    }

    public String getCopyrightLinkText() {
        return copyrightLink.getText();
    }
}
