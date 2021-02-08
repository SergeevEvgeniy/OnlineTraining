package com.sergeev.onlinetraining.config;

/**
 *
 * @author sea
 */
public class DatabaseConfig {

    private static final String URL = "jdbc:h2:~/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public String getUser() {
        return USER;
    }

    public String getPassword() {
        return PASSWORD;
    }

    public String getUrl() {
        return URL;
    }
}
