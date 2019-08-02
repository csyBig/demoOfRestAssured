package com.csy.api.scenario.article

import com.csy.api.remote.ArticleClient
import com.csy.api.repository.ArticleRepository
import spock.lang.Specification

class SearchArticleTest extends Specification {

    ArticleClient articleClient
    ArticleRepository articleRepository

    def setup() {
        articleClient = new ArticleClient()
        articleRepository = new ArticleRepository()
    }


    def "search article by keyword"() {
        given: "no given"

        when: "call the search article com"
        def searchResultFromDB = articleRepository.getArticleInfosByTitle(keyword)

        def response = articleClient.searchArticle(keyword)


        then: "check the response article contain the keywords"
        def contents = response.path("")



        where:
        keyword | nothing
        "csy"   | ""
    }
}
