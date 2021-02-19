package com.sergeev.onlinetraining.dao.impl;

import com.sergeev.onlinetraining.dao.CRUDdaoImpl;
import com.sergeev.onlinetraining.model.Subscription;
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
public class SubscriptionDaoImpl extends CRUDdaoImpl<Subscription> {

    private static final Logger LOG = LoggerFactory.getLogger(SubscriptionDaoImpl.class.getName());

    @Override
    protected List<Subscription> parseResultSet(ResultSet rs) {
        List<Subscription> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Subscription s = new Subscription();
                s.setId(rs.getInt("SUBSCRIPTIONID"));
                s.setStudentId(rs.getInt("userid"));
                s.setCourseId(rs.getInt("courseid"));
                result.add(s);
            }
        } catch (SQLException ex) {
            LOG.error("Error parsing User ", ex);
        }
        return result;
    }

    @Override
    protected String getCreateQuery(Subscription subscription) {
        return "INSERT INTO \"PUBLIC\".\"SUBSCRIPTION\" VALUES ("
                + subscription.getId()
                + ","
                + subscription.getStudentId()
                + ","
                + subscription.getCourseId()
                + ")";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM \"PUBLIC\".\"SUBSCRIPTION\"";
    }

    @Override
    protected String getUpdateQuery(Subscription subscription) {
        return "UPDATE \"PUBLIC\".\"SUBSCRIPTION\" SET "
                + "USERID=" + subscription.getStudentId()
                + "COURSEID=" + subscription.getCourseId()
                + "WHERE SUBSCRIPTIONID=" + subscription.getId();
    }

    @Override
    protected String getDeleteQuery(Subscription subscription) {
        return "Delete FROM \"PUBLIC\".\"SUBSCRIPTION\" where SUBSCRIPTIONID=" + subscription.getId();
    }

}
