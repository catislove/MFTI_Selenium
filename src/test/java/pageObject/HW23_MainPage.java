package pageObject;

import components.HW23_FooterComponent;
import components.HW23_HeaderComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class HW23_MainPage extends HW23_BasePage{
    @FindBy(linkText = "Login form")
    @CacheLookup
    WebElement loginFormButton;

    HW23_HeaderComponent header;
    HW23_FooterComponent footer;

    public HW23_MainPage(String browser) {
        super(browser);
        PageFactory.initElements(driver, this);
        this.header = new HW23_HeaderComponent(driver);
        visit("https://bonigarcia.dev/selenium-webdriver-java/");
    }

    public HW23_FactoryLoginPage openLoginPage() {
        click(loginFormButton);
        assertThat(driver.getCurrentUrl()).isEqualTo("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
        return new HW23_FactoryLoginPage(driver);
    }

    public HW23_HeaderComponent header() {
        return header;
    }

    public HW23_FooterComponent footer() {
        return footer;
    }
}
