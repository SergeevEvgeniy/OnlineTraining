package com.sergeev.onlinetraining.service;

import com.sergeev.onlinetraining.dao.CRUDdao;
import com.sergeev.onlinetraining.dao.impl.CourseDaoImpl;
import com.sergeev.onlinetraining.model.Course;
import java.util.List;

/**
 *
 * @author sea
 */
public class CourseService {

    private final CRUDdao<Course> dao = new CourseDaoImpl();

    public void create(Course course) {
        dao.create(course);
    }

    public List<Course> getAll() {
        return dao.getAll();
    }

    public Course getById(String param) {
        return dao.getOneByMark("courseId", param);
    }

    public void update(Course course) {
        dao.update(course);
    }

    public void delete(Course course) {
        dao.delete(course);
    }
}
