package com.aktog.yusuf.qahomework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.http.HttpResponseException;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringBootTest
public class SwaggerApiTest {
    public final String baseUri = "https://generator.swagger.io/api";

    @Test
    public void testGetClientByLanguage_whenLanguageIsValid_shouldReturn2xxSuccessful() {

        RestAssured.given()
                .baseUri(baseUri)
                .basePath("gen/clients/{language}")
                .pathParam("language", "java")
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetClientByLanguage_whenLanguageIsNotValid_shouldReturn4xxBadRequest() {

        Assert.assertThrows(HttpResponseException.class, () ->
                RestAssured
                        .given()
                        .baseUri(baseUri)
                        .basePath("gen/clients/{language}")
                        .pathParam("language", "An Invalid language")
                        .contentType(ContentType.JSON)
                        .when()
                        .get()
        );
        // {"swaggerUrl":"http://petstore.swagger.io/v2/swagger.json"}
    }

    @Test
    public void testGenerateClientLibrary_whenLanguageIsValidAndBodyIsValid_shouldReturn2xxSuccessful() {


        ObjectMapper mapper = new ObjectMapper();
        ObjectNode body = mapper.createObjectNode();
        body.put("swaggerUrl", "http://petstore.swagger.io/v2/swagger.json");

        RestAssured
                .given()
                .baseUri(baseUri)
                .basePath("gen/clients/{language}")
                .pathParam("language", "java")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post()
                .then()
                .statusCode(200);
    }

    @Test
    public void testGenerateClientLibrary_whenLanguageIsNotValidAndBodyIsValid_shouldReturn4xxBadRequest() {


        ObjectMapper mapper = new ObjectMapper();
        ObjectNode body = mapper.createObjectNode();
        body.put("swaggerUrl", "http://petstore.swagger.io/v2/swagger.json");

         RestAssured
                .given()
                .baseUri(baseUri)
                .basePath("gen/clients/{language}")
                .pathParam("language", "not valid language")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post()
                .then()
                .statusCode(400);
    }

    @Test
    public void testGenerateClientLibrary_whenLanguageIsValidAndBodyIsNotValid_shouldReturn4xxBadRequest() {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode body = mapper.createObjectNode();
        // empty body
        //body.put("swaggerUrl", "http://petstore.swagger.io/v2/swagger.json");

        RestAssured
                .given()
                .baseUri(baseUri)
                .basePath("gen/clients/{language}")
                .pathParam("language", "java")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post()
                .then()
                .statusCode(400);
    }

    @Test
    public void testGenerateClientLibrary_whenLanguageIsNotValidAndBodyIsNotValid_shouldReturn4xxBadRequest() {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode body = mapper.createObjectNode();
        // do not send body
        //body.put("swaggerUrl", "http://petstore.swagger.io/v2/swagger.json");
        RestAssured
                .given()
                .baseUri(baseUri)
                .basePath("gen/clients/{language}")
                .pathParam("language", "not valid language")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post()
                .then()
                .statusCode(400);
    }
}
