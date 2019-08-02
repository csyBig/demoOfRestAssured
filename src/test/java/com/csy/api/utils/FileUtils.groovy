package com.csy.api.utils

import com.google.common.io.Resources
import org.yaml.snakeyaml.Yaml

class FileUtils {
    private static BASE_PATH = "com/csy/api"

    def static getYamlFile(filePath) {
        def path = "${BASE_PATH}/${filePath}"
        def resource = Resources.getResource(path)
        def contents = new Yaml().load(new File(resource.toURI()).newInputStream())
        contents
    }


}
