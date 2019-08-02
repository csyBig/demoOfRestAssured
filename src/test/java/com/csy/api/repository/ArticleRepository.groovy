package com.csy.api.repository

import com.csy.api.sqlConstant.ArticleConstant
import com.csy.api.utils.DataBaseUtils

class ArticleRepository extends DataBaseUtils {

    def getArticleInfosByTitle(def articleTitle) {
        def searchArticleTitle = "%${articleTitle}%" as String
        def listOfResults = sql.rows(ArticleConstant.getArticleInfosByTitle, [searchArticleTitle])
        listOfResults ? listOfResults : null
    }

}
