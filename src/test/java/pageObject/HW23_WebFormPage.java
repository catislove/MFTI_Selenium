package pageObject;

import components.HW23_FooterComponent;
import components.HW23_HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HW23_WebFormPage extends HW23_BasePage{
    @FindBy(id = "my-text-id")
    @CacheLookup
    WebElement textInput;

    @FindBy(name = "my-password")
    @CacheLookup
    WebElement password;

    @FindBy(name = "my-textarea")
    @CacheLookup
    WebElement textarea;

    @FindBy(name = "my-disabled")
    @CacheLookup
    WebElement disabledInput;

    @FindBy(name = "my-readonly")
    @CacheLookup
    WebElement readonlyInput;

    @FindBy(xpath = "//select[@name='my-select']/option[@value='2']")
    @CacheLookup
    WebElement dropdownSelect;

    @FindBy(name = "my-datalist")
    @CacheLookup
    WebElement dropdownDatalist;

    @FindBy(name = "my-file")
    @CacheLookup
    WebElement fileUpload;

    @FindBy(id = "my-check-1")
    @CacheLookup
    WebElement checkedCheckbox;

    @FindBy(name = "my-colors")
    @CacheLookup
    WebElement colorPicker;

    @FindBy(name = "my-date")
    @CacheLookup
    WebElement dataPicker;

    @FindBy(name = "my-range")
    @CacheLookup
    WebElement exampleRange;

    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    WebElement submit;
    @FindBy(css = "h1.display-6")
    @CacheLookup
    WebElement submit_check;


    String filePath = "src/test/resources/text.txt";
    HW23_HeaderComponent header;
    HW23_FooterComponent footer;

    public HW23_WebFormPage(String browser) {
        super(browser);
        PageFactory.initElements(driver, this);
        header = new HW23_HeaderComponent(driver);
        footer = new HW23_FooterComponent(driver);
        visit("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
    }

    public void fill_in() {
        type(textInput, "Text input");
        type(password, "password");
        type(textarea, "textarea");
        isEnabled(disabledInput);
        click(dropdownSelect);
        type(dropdownDatalist, "San Francisco");
        fileUpload(fileUpload, filePath);
        type(colorPicker, "#ff0000");
        type(dataPicker, "11/25/2024");
        type(exampleRange, "5");
    }

    public void submit(){
        click(submit);
        assertEquals("Form submitted", submit_check.getText());
    }
}
