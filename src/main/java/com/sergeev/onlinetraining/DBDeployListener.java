package com.sergeev.onlinetraining;

import com.sergeev.onlinetraining.config.DatabaseConfig;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sea
 */
@WebListener
public class DBDeployListener implements ServletContextListener {

    private final DatabaseConfig connect = new DatabaseConfig();

    private static final Logger LOG = LoggerFactory.getLogger(DBDeployListener.class);

    private static final String CREATETABLES = "create_table.sql";
    private static final String INITTABLES = "insert_def_values.sql";

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        try {
            DriverManager.registerDriver(new org.h2.Driver());
            if (executeScript(CREATETABLES)) {
                if (executeScript(INITTABLES)) {
                    LOG.info("db creation scripts was successfully executed");
                } else {
                    LOG.info("tables created whithout any data");
                }
            } else {
                LOG.info("db already exist");
            }
        } catch (SQLException ex) {
            LOG.error("Can't load db driver", ex);
            throw new RuntimeException(ex);
        }
    }

    /**
     * execute sql-script from resurce file
     *
     * @param filename resurce filename with sql-script
     * @return true if script was successfully executed, false otherwise
     */
    private boolean executeScript(String filename) {
        try (Connection con = DriverManager.getConnection(connect.getUrl(),
                connect.getUser(), connect.getPassword());
                Statement stmt = con.createStatement()) {

            stmt.executeUpdate(readFileAsText(filename));
            return true;
        } catch (SQLException sqlEx) {
            LOG.error("error executing script");
        } catch (IOException ex) {
            LOG.error("error of reading sql-query ", ex);
        }
        return false;
    }

    private String readFileAsText(String filename) throws IOException {
        InputStream is = DBDeployListener.class.getClassLoader().getResourceAsStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String readString;
        String query = "";

        while ((readString = br.readLine()) != null) {
            query += readString;
        }
        return query;
    }
}
