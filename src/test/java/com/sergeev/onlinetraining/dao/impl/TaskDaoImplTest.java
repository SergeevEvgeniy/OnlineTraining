package com.sergeev.onlinetraining.dao.impl;

import com.sergeev.onlinetraining.model.Course;
import com.sergeev.onlinetraining.model.Task;
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
public class TaskDaoImplTest {

    private final TaskDaoImpl dao = new TaskDaoImpl();
    private Task task;
    private static final Logger LOG = LoggerFactory.getLogger(TaskDaoImplTest.class.getName());

    private Task getTask(Task t) {
        return dao.getOneByMark("taskid", Integer.toString(t.getId()));
    }

    /**
     * Test of create method of class TaskDaoImpl
     */
    @Before
    public void testCreate() {
        UserRole userRole = new UserRole("userRole");
        userRole.setId(1);
        User user = new User("email", "nickname", "password", userRole);
        user.setId(1);
        Course course = new Course("name", "description", user);
        course.setId(1);
        task = new Task("name", "descriprion", course);
        task.setId(1000);

        Assert.assertNull(getTask(task));
        dao.create(task);
        Assert.assertNotNull(getTask(task));
    }

    /**
     * Test of update and get methods of class TaskDaoImpl.
     */
    @Test
    public void testUpdate() {
        LOG.info("test update Task");
        task.setDescriprion("another description");
        dao.update(task);
        Task updatedTask = getTask(task);
        Assert.assertNotNull(updatedTask);
        Assert.assertTrue(task.equals(updatedTask));
    }

    /**
     * Test of delete method of class TaskDaoImpl.
     */
    @After
    public void testDelete() {
        LOG.info("test delete Task");
        Task taskFromDao = getTask(task);
        Assert.assertNotNull(taskFromDao);
        dao.delete(taskFromDao);
        Assert.assertNull(getTask(task));
    }

}
