package pageObjectTests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageObject.HW23_LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

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
    void testLoginSuccess() {
        login.with("user", "user");
        assertThat(login.successBoxPresent()).isTrue();
        assertThat(login.invalidCredentialsBoxPresent()).isFalse();
    }

    @Test
    void testLoginFailure() {
        login.with("test", "test");
        assertThat(login.successBoxPresent()).isFalse();
        assertThat(login.invalidCredentialsBoxPresent()).isTrue();
    }
}
