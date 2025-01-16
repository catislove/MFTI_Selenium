import controllers.FluentUserController;
import org.junit.jupiter.api.*;

import static testdata.ApiTestData.*;

public class HW26_FluentControllerApiTests {
    FluentUserController fluentUserController = new FluentUserController();

    @BeforeEach
    @AfterEach
    void clear() {
        fluentUserController.deleteUserByName(USER_FOR_POST.getUsername());
    }


    @Test
    @Tag("extended")
    @DisplayName("Check create user")
    void checkCreateUser() {
        String expectedId = fluentUserController.addUser(USER_FOR_POST)
                .statusCodeIs(200)
                .getJsonValue("message");

        fluentUserController.getUserByName(USER_FOR_POST.getUsername())
                .statusCodeIs(200)
                .jsonValueIs("id", expectedId)
                .jsonValueIs("username", USER_FOR_POST.getUsername())
                .jsonValueIs("firstName", USER_FOR_POST.getFirstName())
                .jsonValueIs("lastName", USER_FOR_POST.getLastName())
                .jsonValueIs("email", USER_FOR_POST.getEmail());
    }

    @Test
    @Tag("extended")
    @DisplayName("Check update user")
    void checkUpdateUser() {
        fluentUserController.addUser(USER_FOR_PUT)
                .statusCodeIs(200)
                .getJsonValue("message");

        String expectedId = fluentUserController.updateUserByName(USER_FOR_PUT.getUsername())
                .statusCodeIs(200)
                .getJsonValue("message");

        fluentUserController.getUserByName(USER_FOR_PUT.getUsername())
                .statusCodeIs(200)
                .jsonValueIs("id", expectedId)
                .jsonValueIs("username",USER_FOR_PUT.getUsername());
    }

    @Test
    @Tag("extended")
    @DisplayName("Check delete user")
    void checkDeleteUser() {
        fluentUserController.addUser(USER_FOR_DELETE)
                .statusCodeIs(200)
                .getJsonValue("message");

        fluentUserController.deleteUserByName(USER_FOR_DELETE.getUsername())
                .statusCodeIs(200)
                .getJsonValue("message");

        fluentUserController.getUserByName(USER_FOR_DELETE.getUsername())
                .statusCodeIs(404);
    }

    @Test
    @Tag("extended")
    @DisplayName("Check get user")
    void checkGetUser() {
        String expectedId = fluentUserController.addUser(USER_FOR_GET)
                .statusCodeIs(200)
                .getJsonValue("message");

        fluentUserController.getUserByName(USER_FOR_GET.getUsername())
                .statusCodeIs(200)
                .jsonValueIs("id", expectedId)
                .jsonValueIs("username",USER_FOR_GET.getUsername());
    }
}
