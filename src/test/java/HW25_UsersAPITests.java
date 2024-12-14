import org.junit.jupiter.api.Test;
import models.User;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.startsWith;

public class HW25_UsersAPITests {

    @Test
    void createUserPostTest() {
        String endpoint = "https://petstore.swagger.io/v2/user";
        String usernameForPost = "username1";
        User userForPost = new User(1, usernameForPost, "firstName1", "lastName1", "email1@gmail.com", "qwerty1", "11111111", 1);
        var response = given().
                header("accept", "application/json").
                header("Content-Type", "application/json").
                body(userForPost).
                when().
                post(endpoint).
                then();
        response.log().body();
        response.statusCode(200);

        String endpoint2 = "https://petstore.swagger.io/v2/user/" + usernameForPost;
        given().
                when().
                get(endpoint2).
                then().
                log().
                all().
                assertThat().
                statusCode(200).
                body("username", equalTo("username1")).
                body("firstName", startsWith("firstName1")).
                body("lastName", equalToIgnoringCase("LASTNAME1")).
                body("email", matchesPattern("^[a-zA-Z0-9._%+-]+@gmail\\.com$")).
                body("password", equalTo("qwerty1")).
                body("phone", equalTo("11111111"));
    }


    @Test
    void getUserByName() {
        String endpointPost = "https://petstore.swagger.io/v2/user";
        String usernameForGet = "userForGet";
        User userForGet = new User(1, usernameForGet, "firstName1", "lastName1", "email1@gmail.com", "qwerty1", "11111111", 1);
        var response = given().
                header("accept", "application/json").
                header("Content-Type", "application/json").
                body(userForGet).
                when().
                post(endpointPost).
                then();
        response.log().body();
        response.statusCode(200);

        String endpointGet = "https://petstore.swagger.io/v2/user/" + usernameForGet;
        given().
                when().
                get(endpointGet).
        then().
                log().all()
                .statusCode(200);
    }


    @Test
    void putUserByName() {
        String endpointPost = "https://petstore.swagger.io/v2/user";
        String usernameForPut = "userForPut";
        User userForPut = new User(1, usernameForPut, "firstName1", "lastName1", "email1@gmail.com", "qwerty1", "11111111", 1);
        var response = given().
                header("accept", "application/json").
                header("Content-Type", "application/json").
                body(userForPut).
                when().
                post(endpointPost).
                then();
        response.log().body();
        response.statusCode(200);


        String endpointPut = "https://petstore.swagger.io/v2/user/" + usernameForPut;
        String body = """
                {
                  "id": 0,
                  "username": "userForPut",
                  "firstName": "firstNamePut",
                  "lastName": "lastNamePut",
                  "email": "emailPut@gmail.com",
                  "password": "qwertyPut",
                  "phone": "11111111",
                  "userStatus": 0
                }
                """;
        var responsePut = given().
                header("accept", "application/json").
                header("Content-Type", "application/json").
                body(body).
                when().
                put(endpointPut).
                then();
        responsePut.statusCode(200);
        given().
                when().
                get(endpointPut).
                then().
                log().
                all().
                assertThat().
                statusCode(200).
                body("username", equalTo("userForPut")).
                body("firstName", startsWith("firstNamePut")).
                body("lastName", equalToIgnoringCase("LASTNAMEPut")).
                body("email", matchesPattern("^[a-zA-Z0-9._%+-]+@gmail\\.com$")).
                body("password", equalTo("qwertyPut")).
                body("phone", equalTo("11111111"));
    }


    @Test
    void deleteUserByName() {
        String endpointPost = "https://petstore.swagger.io/v2/user";
        String usernameForDelete = "userForDelete";
        User userForDelete = new User(1, usernameForDelete, "firstName1", "lastName1", "email1@gmail.com", "qwerty1", "11111111", 1);
        var response = given().
                header("accept", "application/json").
                header("Content-Type", "application/json").
                body(userForDelete).
                when().
                post(endpointPost).
                then();
        response.log().body();
        response.statusCode(200);

        String endpointDelete = "https://petstore.swagger.io/v2/user/" + usernameForDelete;
        var responseDelete = given().
                when().
                delete(endpointDelete).
                then();
        responseDelete.log().body();
        responseDelete.statusCode(200);
    }
}
