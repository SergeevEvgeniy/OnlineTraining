package com.sergeev.onlinetraining.dao.impl;

import com.sergeev.onlinetraining.config.DatabaseConfig;
import com.sergeev.onlinetraining.dao.CRUDdaoImpl;
import com.sergeev.onlinetraining.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sea
 */
public class UserDaoImpl extends CRUDdaoImpl<User> {

    private static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class.getName());

    @Override
    protected List<User> parseResultSet(ResultSet rs) {
        List<User> result = new LinkedList<>();
        try {
            while (rs.next()) {
                User user = new User();
                UserRoleDaoImpl urdi = new UserRoleDaoImpl();
                user.setId(rs.getInt("userid"));
                user.setEmail(rs.getString("email"));
                user.setNickname(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                user.setUserRole(urdi.getOneByMark("userroleid", rs.getString("userroleid")));
                result.add(user);
            }
        } catch (SQLException ex) {
            LOG.error("Error parsing User ", ex);
        }
        return result;
    }

    @Override
    protected String getCreateQuery(User user) {
        return "INSERT INTO \"PUBLIC\".\"USER\" VALUES ("
                + user.getId()
                + ", '"
                + user.getEmail()
                + "', '"
                + user.getNickname()
                + "', '"
                + user.getPassword()
                + "', "
                + user.getUserRole().getId()
                + ")";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM USER";
    }

    @Override
    protected String getUpdateQuery(User user) {
        return "UPDATE \"PUBLIC\".\"USER\" SET"
                + " EMAIL = '" + user.getEmail()
                + "', nickname = '" + user.getNickname()
                + "', password = '" + user.getPassword()
                + "', USERROLEID = " + user.getUserRole().getId()
                + " WHERE userid = " + user.getId();
    }

    @Override
    protected String getDeleteQuery(User user) {
        return "Delete FROM user WHERE userid = " + user.getId();
    }

}
