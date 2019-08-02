package com.csy.api.utils

import groovy.sql.Sql

class DataBaseUtils {
    ConfigParserUtils configParser = new ConfigParserUtils()
    def configs
    Sql sql


    Sql getSql() {
        configs = configParser.getConfigs()
        if (sql == null) {
            def mysqlDB = [
                    driver  : "com.mysql.jdbc.Driver",
                    ulr     : configs.app.db.dbUrl,
                    user    : configs.app.db.user,
                    password: configs.app.db.password
            ]
            sql = Sql.newInstance(mysqlDB.ulr, mysqlDB.user, mysqlDB.password, mysqlDB.driver)
        }
        return sql
    }

}
