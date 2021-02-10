package com.sergeev.onlinetraining.dao.impl;

import com.sergeev.onlinetraining.model.Course;
import com.sergeev.onlinetraining.model.User;
import com.sergeev.onlinetraining.model.UserRole;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author sea
 */
public class CourseDaoImplTest {

    private final CourseDaoImpl dao = new CourseDaoImpl();
    private Course course;
    private static final Logger LOG = LoggerFactory.getLogger(CourseDaoImplTest.class.getName());

    /**
     * The initialization block with a test object creation
     */
    @Before
    public void testCreate() {
        UserRole userRole = new UserRole("userRole");
        userRole.setId(1);

        User user = new User("email", "nickname", "password", userRole);
        user.setId(1);

        Course c = new Course("TestCourse", "course for test", user);
        c.setId(1000);
        course = c;

        System.out.println("test create");
        dao.create(course);
        Assert.assertNotNull(getCourse(course));
    }

    private Course getCourse(Course c) {
        return dao.getOneByMark("courseid", Integer.toString(c.getId()));
    }

    /**
     * Test of update and get methods of class CourseDaoImpl.
     */
    @Test
    public void testUpdate() {
        LOG.info("test update course");
        course.setDescription("another description");
        dao.update(course);
        Course updatedCourse = getCourse(course);
        Assert.assertNotNull(updatedCourse);
        Assert.assertFalse(course.equals(updatedCourse));
    }

    /**
     * Test of delete methods of class CourseDaoImpl.
     */
    @After
    public void testDelete() {
        LOG.info("test delete course");
        Course courseFromDao = getCourse(course);
        Assert.assertNotNull(courseFromDao);
        dao.delete(course);
        Assert.assertNull(getCourse(course));
    }
}
