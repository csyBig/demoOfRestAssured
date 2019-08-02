package com.csy.api.remote

import io.restassured.http.ContentType
import io.restassured.response.Response

import static io.restassured.RestAssured.given

class ArticleClient {
    def loginCookie
    def configs
    LoginClient loginClient

    ArticleClient() {
        loginClient = new LoginClient()
        loginCookie = loginClient.initLogin()
        configs = loginClient.configs
    }


    def searchArticle(def keyword) {
        Response rs = given()
                .contentType(ContentType.URLENC)
                .cookie(loginCookie)
                .baseUri(configs.app.url)
                .formParam("state", 1)
                .formParam("page", 1)
                .formParam("count", 6)
                .formParam("keywords", (String)keyword)
        .log().all()
                .when()
                .get("article/all")
                .then()
        .log().all()
                .assertThat().statusCode(200)
                .extract()
                .response()
        rs


    }

}
