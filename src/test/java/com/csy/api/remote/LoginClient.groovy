package com.csy.api.remote

import com.csy.api.utils.ConfigParserUtils
import io.restassured.http.ContentType
import io.restassured.response.Response

import static io.restassured.RestAssured.given

class LoginClient {
    def configs

    LoginClient(){
        configs = new ConfigParserUtils().getConfigs()
    }

    def initLogin(){
        getLoginCookie().headers().getValue("set-cookie")
    }

    private def getLoginCookie(){
        Response rs = given()
                .contentType(ContentType.URLENC)
                .baseUri(configs.app.url)
                .formParam("username", (String) configs.app.auth.user)
                .formParam("password", (String) configs.app.auth.password)
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .extract()
                .response()
        rs
    }
}
