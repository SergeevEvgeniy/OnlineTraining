package com.sergeev.onlinetraining.dao.impl;

import com.sergeev.onlinetraining.dao.CRUDdaoImpl;
import com.sergeev.onlinetraining.model.Task;
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
public class TaskDaoImpl extends CRUDdaoImpl<Task> {

    private final String SEPARATOR = ", '";
    private static final Logger LOG = LoggerFactory.getLogger(UserRoleDaoImpl.class.getName());

    @Override
    protected List<Task> parseResultSet(ResultSet rs) {
        List<Task> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Task task = new Task();
                CourseDaoImpl cdi = new CourseDaoImpl();
                task.setId(rs.getInt("taskid"));
                task.setName(rs.getString("name"));
                task.setDescriprion(rs.getString("description"));
                task.setCourse(cdi.getOneByMark("courseid", rs.getString("courseid")));
                result.add(task);
            }
        } catch (SQLException ex) {
            LOG.error("Error parsing Task ", ex);
        }
        return result;
    }

    @Override
    protected String getCreateQuery(Task task) {
        return " INSERT INTO \"PUBLIC\".TASK VALUES ("
                + task.getId()
                + SEPARATOR
                + task.getName()
                + SEPARATOR
                + task.getDescriprion()
                + SEPARATOR
                + task.getCourse().getId() + ");";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM \"PUBLIC\".TASK";
    }

    @Override
    protected String getUpdateQuery(Task task) {
        return "UPDATE \"PUBLIC\".TASK SET "
                + "\"NAME\" = '" + task.getName()
                + "', DESCRIPTION = '" + task.getDescriprion()
                + "', COURSEID = " + task.getCourse().getId()
                + " WHERE TASKID = " + task.getId();
    }

    @Override
    protected String getDeleteQuery(Task task) {
        return "DELETE FROM \"PUBLIC\".TASK WHERE taskid = " + task.getId();
    }

}