package com.sergeev.onlinetraining.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sea
 */
public class DatabaseConfig {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(DatabaseConfig.class.getName());
    private final String PROPERTY_PATH = "src/main/resources/application.properties";

    private String url;
    private String user;
    private String password;

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public DatabaseConfig() {
        try {
            File file = new File(PROPERTY_PATH);
            Properties properties = new Properties();
            properties.load(new FileReader(file));

            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");
        } catch (FileNotFoundException ex) {
            LOG.error("File Not Found", ex);
        } catch (IOException ex) {
            LOG.error("I/o exception occured ", ex);
        }
    }
}
