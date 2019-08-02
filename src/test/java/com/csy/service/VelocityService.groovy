package com.csy.service

import org.apache.velocity.Template
import org.apache.velocity.VelocityContext
import org.apache.velocity.app.Velocity
import org.apache.velocity.app.VelocityEngine

class VelocityService {
    VelocityEngine velocityEngine
    VelocityContext velocityContext
    StringWriter stringWriter

    private static BASE_PATH = "com/csy/api"


    VelocityService(){
        velocityContext = new VelocityContext()
        velocityEngine = new VelocityEngine()
        stringWriter = new StringWriter()
        velocityEngine.setProperty("resource.loader", "class")
        velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader")
        velocityEngine.setProperty(Velocity.INPUT_ENCODING, "UTF-8")
        velocityEngine.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8")
        velocityEngine.init()
    }

    def getXXBodyFromTemplate(objectValues){
        def templatePath = "${BASE_PATH}/velocityTemplate/xxTemplate.json"
        velocityContext.put("theObjectValues", objectValues)
        Template template = velocityEngine.getTemplate(templatePath)
        template.merge(velocityContext, stringWriter)
        stringWriter.toString()
    }

}
