package pageObject;

import components.HW23_FooterComponent;
import components.HW23_HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HW23_FactoryLoginPage extends HW23_BasePage{
    @FindBy(id = "username")
    @CacheLookup
    WebElement usernameInput;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordInput;

    @FindBy(css = "button")
    @CacheLookup
    WebElement submitButton;

    @FindBy(id = "success")
    @CacheLookup
    WebElement successBox;

    @FindBy(id = "invalid")
    @CacheLookup
    WebElement invalidCredentialsBox;

    HW23_HeaderComponent header;
    HW23_FooterComponent footer;

    public HW23_FactoryLoginPage(String browser) {
        super(browser);
        PageFactory.initElements(driver, this);
        header = new HW23_HeaderComponent(driver);
        visit("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }

    public HW23_FactoryLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        header = new HW23_HeaderComponent(driver);
    }

    public void with(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(submitButton);
    }

    public boolean successBoxPresent() {
        return isDisplayed(successBox);
    }

    public boolean invalidCredentialsBoxPresent() {
        return isDisplayed(invalidCredentialsBox);
    }

    public HW23_HeaderComponent header() {
        return header;
    }

    public HW23_FooterComponent footer() {
        return footer;
    }
}
