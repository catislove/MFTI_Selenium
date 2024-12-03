package pageObjectTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageObject.HW23_WebFormPage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void testLoginSuccess() {
        webFormPage.fill_in();
        webFormPage.submit();
    }
}
