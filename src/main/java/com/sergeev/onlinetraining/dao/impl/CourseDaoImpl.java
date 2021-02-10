package com.sergeev.onlinetraining.dao.impl;

import com.sergeev.onlinetraining.dao.CRUDdaoImpl;
import com.sergeev.onlinetraining.model.Course;
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
public class CourseDaoImpl extends CRUDdaoImpl<Course> {

    private static final Logger LOG = LoggerFactory.getLogger(CourseDaoImpl.class.getName());

    @Override
    protected List<Course> parseResultSet(ResultSet rs) {
        List<Course> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Course course = new Course();
                UserDaoImpl udi = new UserDaoImpl();
                course.setId(rs.getInt("courseid"));
                course.setName(rs.getString("name"));
                course.setDescription(rs.getString("description"));
                course.setLector(udi.getOneByMark("userid", rs.getString("lector")));
                result.add(course);
            }
        } catch (SQLException ex) {
            LOG.error("Error parsing Course ", ex);
        }
        return result;
    }

    @Override
    protected String getCreateQuery(Course course) {
        return "INSERT INTO \"PUBLIC\".COURSE VALUES ("
                + course.getId()
                + ", '"
                + course.getName()
                + "', '"
                + course.getDescription()
                + "', "
                + course.getLector().getId()
                + ")";
    }

    @Override
    protected String getSelectQuery() {
        return "SELECT * FROM \"PUBLIC\".COURSE";
    }

    @Override
    protected String getUpdateQuery(Course course) {
        return "UPDATE \"PUBLIC\".COURSE SET "
                + "\"NAME\" = '" + course.getName()
                + "', DESCRIPTION = '" + course.getDescription()
                + "',LECTOR = " + course.getLector().getId()
                + " WHERE COURSEID = " + course.getId();
    }

    @Override
    protected String getDeleteQuery(Course course) {
        return "Delete FROM \"PUBLIC\".COURSE WHERE courseid = " + course.getId();
    }

}
