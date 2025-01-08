import io.restassured.path.json.JsonPath;
import models.User;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.path.json.JsonPath.from;
import static org.assertj.core.api.Assertions.assertThat;

public class HW26_jsonPath_jsonSchema {

    @Test
    void jsonPathTest() {
        User userForPost = new User(123, "userName123", "firstName123", "lastName123",
                "email123@gmail.com", "qwerty123", "12345678", 0);
        String endpointPost = "https://petstore.swagger.io/v2/user/";
        String endpointGet = "https://petstore.swagger.io/v2/user/" + userForPost.getUsername();

        String jsonResponsePost = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(userForPost)
                .when()
                .post(endpointPost)
                .then().toString();

        String jsonResponseGet = given().when().get(endpointGet).asString();
        JsonPath jsonPath = from(jsonResponseGet);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(jsonPath.getLong("id")).isPositive();
        softly.assertThat(jsonPath.getString("firstName")).isEqualTo(userForPost.getFirstName());
        softly.assertThat(jsonPath.getString("lastName")).isEqualTo(userForPost.getLastName());
        softly.assertThat(jsonPath.getString("username")).isEqualTo(userForPost.getUsername());
        softly.assertAll();
    }

    @Test
    void jsonSchemaTest() {
        User userForPost = new User(123, "userName123", "firstName123", "lastName123",
                "email123@gmail.com", "qwerty123", "12345678", 0);
        String endpointPost = "https://petstore.swagger.io/v2/user/";
        String endpointGet = "https://petstore.swagger.io/v2/user/" + userForPost.getUsername();

        given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(userForPost)
                .when()
                .post(endpointPost)
                .then();

        given().
                when().
                get(endpointGet).
                then().
                assertThat().
                body(matchesJsonSchemaInClasspath("jsonSchema/userSchema.json"));
    }
}
