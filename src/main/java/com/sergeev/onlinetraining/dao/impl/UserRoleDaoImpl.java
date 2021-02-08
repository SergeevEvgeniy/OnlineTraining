package com.sergeev.onlinetraining.dao.impl;

import com.sergeev.onlinetraining.dao.CRUDdaoImpl;
import com.sergeev.onlinetraining.model.UserRole;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sea
 */
public class UserRoleDaoImpl extends CRUDdaoImpl<UserRole> {

    private static final Logger LOG = LoggerFactory.getLogger(UserRoleDaoImpl.class.getName());

    @Override
    protected List<UserRole> parseResultSet(ResultSet rs) {
        List<UserRole> result = new LinkedList<>();
        try {
            while (rs.next()) {
                UserRole userRole = new UserRole();
                userRole.setId(rs.getInt("userroleid"));
                userRole.setUserRole(rs.getString("userrole"));
                result.add(userRole);
            }
        } catch (SQLException ex) {
            LOG.error("Error parsing UserRole ", ex);
        }
        return result;
    }

    @Override
    protected String getCreateQuery(UserRole userRole) {
        return ("INSERT INTO userrole VALUES ("
                + userRole.getId()
                + ", '"
                + userRole.getUserRole()
                + "')");
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM USERROLE";
    }

    @Override
    protected String getUpdateQuery(UserRole userRole) {
        return "update userrole SET "
                + "userrole = '" + userRole.getUserRole()
                + "' WHERE userroleid = " + userRole.getId();
    }

    @Override
    protected String getDeleteQuery(UserRole userRole) {
        return "Delete FROM userrole WHERE userroleid = " + userRole.getId();
    }

}
