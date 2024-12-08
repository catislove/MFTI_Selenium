package pageObjectTests;

import extentions.HW24_AllureExtension;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import pageObject.HW23_WebFormPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Extensions")
@ExtendWith(HW24_AllureExtension.class)
@Story("WebFormPageTests")
public class HW23_WebFormPageTests {
    HW23_WebFormPage webFormPage;

    @BeforeEach
    void setup() {
        webFormPage= new HW23_WebFormPage("chrome");
    }

    @AfterEach
    void teardown() {
        webFormPage.quit();
    }

    @Test
    @Description("Filling out a web form")
    @Link("Jira-3")
    void testWebForm() {
        webFormPage.fill_in();
        webFormPage.submit();
    }
}
