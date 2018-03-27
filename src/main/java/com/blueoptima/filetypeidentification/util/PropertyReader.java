package com.blueoptima.filetypeidentification.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The {@link PropertyReader} implements an application that is used to
 * perform activities related to properties file.
 *
 * @author Bhavesh Patel
 * @version 1.0
 * @since 2018-03-08
 */
public class PropertyReader {

    private Properties properties;

    public PropertyReader(String propFileName) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        properties = new Properties();
        properties.load(inputStream);
    }

    public Properties getProperties() {
        return properties;
    }

    /**
     * This method is used to get value of key from properties file.
     *
     * @param key used to get value from the properties file
     * @return String The value of key
     */
    public String getValue(String key) {
        return properties.getProperty(key);
    }

    /**
     * This method is used to get value of key from properties file.
     * If it's unable to find value in properties file then simply returns the default value.
     *
     * @param key          used to get value from the properties file
     * @param defaultValue return if the value of key not found in properties file.
     * @return
     */
    public String getValue(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
