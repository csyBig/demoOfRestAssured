package com.csy.api.scenario


import io.restassured.http.ContentType
import io.restassured.response.Response
import spock.lang.Specification

import static io.restassured.RestAssured.given

class LoginTest extends Specification {

    def "this case is test login"() {
        given: "the url"
        def baseUrl = "http://localhost:8082"


        when: "visit the login com"
        Response rs = given()
//                .config(RestAssured
//                        .config()
//                        .encoderConfig(EncoderConfig.encoderConfig().encodeContentTypeAs("application/x-www-form-urlencode", ContentType.TEXT)))
                .contentType(ContentType.URLENC)
                .baseUri(baseUrl)
                .formParam("username", (String) "sang")
                .formParam("password", (String) "123")
                .log().all()
                .when()
                .post("login")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .extract()
                .response()

        then: "get the response cookie"
//        def cookies = rs.headers().find{it.toString().contains("set-cookie")}
        def cookies = rs.headers().getValue("set-cookie")

    }
}