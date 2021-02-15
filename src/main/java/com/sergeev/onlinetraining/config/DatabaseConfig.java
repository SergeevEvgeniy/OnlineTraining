package com.sergeev.onlinetraining.config;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sea
 */
public class DatabaseConfig {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(DatabaseConfig.class.getName());
    private final String PROPERTY_FILE = "application.properties";

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
            Properties properties = new Properties();
            properties.load(DatabaseConfig.class.getClassLoader().getResourceAsStream(PROPERTY_FILE));

            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");

            DriverManager.registerDriver(new org.h2.Driver());
        } catch (IOException ex) {
            LOG.error("I/o exception occured ", ex);
        } catch (SQLException ex) {
            LOG.error("Error registration db driver", ex);
        }
    }
}
