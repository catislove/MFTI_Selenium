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
import pageObject.HW23_LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Extensions")
@ExtendWith(HW24_AllureExtension.class)
@Story("LoginFormTests")
public class HW23_LoginPageTests {
    HW23_LoginPage login;

    @BeforeEach
    void setup() {
        login = new HW23_LoginPage("chrome");
    }

    @AfterEach
    void teardown() {
        login.quit();
    }

    @Test
    @Description("Successful authorization")
    @Link("Jira-1")
    void testLoginSuccess() {
        login.with("user", "user");
        assertThat(login.successBoxPresent()).isTrue();
        assertThat(login.invalidCredentialsBoxPresent()).isFalse();
    }

    @Test
    @Description("Authorization failed")
    @Link("Jira-2")
    void testLoginFailure() {
        login.with("test", "test");
        assertThat(login.successBoxPresent()).isFalse();
        assertThat(login.invalidCredentialsBoxPresent()).isTrue();
    }
}
