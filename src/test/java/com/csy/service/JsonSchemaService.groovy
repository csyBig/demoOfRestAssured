package com.csy.service

import groovy.json.JsonOutput
import static org.hamcrest.MatcherAssert.assertThat
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath

class JsonSchemaService {

    void compareObjectWithSchema(def objectValue, def schemaFilePath){
        def objectString = new JsonOutput().toJson(objectValue).toString()
        assertThat(objectString, matchesJsonSchemaInClasspath(schemaFilePath))
    }
}
