package utils;

import java.io.IOException;
import java.util.Properties;

public class SuiteConfiguration {
    private static final String propsUrl = "/config.properties";
    private final Properties properties;

    public SuiteConfiguration() throws IOException {
        properties = new Properties();
        properties.load(SuiteConfiguration.class.getResourceAsStream(System.getProperty("config.properties", propsUrl)));
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}