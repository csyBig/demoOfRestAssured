package com.csy.api.utils

import org.yaml.snakeyaml.Yaml

class ConfigParserUtils {
    private static configs = null
    private static CONFIG_PATH = 'config/config.yml'
    FileUtils fileUtils

    ConfigParserUtils(){
        fileUtils = new FileUtils()
    }

    def getConfigs() {
        if (configs == null) {
            configs = loadConfig()
        }
        return configs
    }

    private def loadConfig() {
        def configContent = fileUtils.getYamlFile(CONFIG_PATH)
        def sysEnv = System.getenv("ACTIVE_ENV")
        def active = sysEnv ? sysEnv : configContent.active
        configContent.app.putAll(configContent.get(active))
        configContent
    }


}
