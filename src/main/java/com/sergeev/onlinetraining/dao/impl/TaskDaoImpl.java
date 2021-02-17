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

    private static final Logger LOG = LoggerFactory.getLogger(TaskDaoImpl.class.getName());

    @Override
    protected List<Task> parseResultSet(ResultSet rs) {
        List<Task> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Task task = new Task();
                CourseDaoImpl cdi = new CourseDaoImpl();
                task.setId(rs.getInt("taskid"));
                task.setName(rs.getString("name"));
                task.setDescription(rs.getString("description"));
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
                + ", '"
                + task.getName()
                + "', '"
                + task.getDescription()
                + "', "
                + task.getCourse().getId() + ")";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM \"PUBLIC\".TASK";
    }

    @Override
    protected String getUpdateQuery(Task task) {
        return "UPDATE \"PUBLIC\".TASK SET "
                + "\"NAME\" = '" + task.getName()
                + "', DESCRIPTION = '" + task.getDescription()
                + "', COURSEID = " + task.getCourse().getId()
                + " WHERE TASKID = " + task.getId();
    }

    @Override
    protected String getDeleteQuery(Task task) {
        return "DELETE FROM \"PUBLIC\".TASK WHERE taskid = " + task.getId();
    }

}
