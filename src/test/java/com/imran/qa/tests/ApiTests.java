package com.imran.qa.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    @BeforeClass
    public void init() { RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; }

    @Test(description = "GET a single post returns the expected schema")
    public void getPost() {
        given().when().get("/posts/1")
            .then().statusCode(200)
            .body("id", equalTo(1))
            .body("userId", notNullValue())
            .body("title", not(emptyString()));
    }

    @Test(description = "GET the post list returns 100 items")
    public void listPosts() {
        given().when().get("/posts")
            .then().statusCode(200).body("size()", equalTo(100));
    }

    @Test(description = "POST creates a resource and echoes the payload")
    public void createPost() {
        given().contentType(ContentType.JSON)
            .body("{\"title\":\"qa\",\"body\":\"regression\",\"userId\":1}")
            .when().post("/posts")
            .then().statusCode(201).body("title", equalTo("qa")).body("id", notNullValue());
    }

    @Test(description = "Unknown resource returns 404")
    public void missingResource() {
        given().when().get("/posts/99999").then().statusCode(404);
    }
}
