package io.dvkdo.eslcoord.api;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
class InstructorResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/api/instructor")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }
    @Test
    @Disabled("not implemented")
    void testSaveInstructors() {
        ArrayList<String> instructors = new ArrayList<>(List.of("Ann Barbara", "Carl Dominic"));
        String json = new Gson().toJson(instructors);
        given()
          .when().body(json)
          .header("Content-Type", "application/json")
          .when()
          .post("/api/instructors")
          .then()
          .statusCode(201);
    }
//https://www.mastertheboss.com/soa-cloud/quarkus/a-practical-guide-for-testing-quarkus-applications/
}