package com.sergeev.onlinetraining.dao.impl;

import com.sergeev.onlinetraining.model.Course;
import com.sergeev.onlinetraining.model.Evaluation;
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
public class EvaluationDaoImplTest {

    private final EvaluationDaoImpl dao = new EvaluationDaoImpl();
    private Evaluation evaluation;
    private static final Logger LOG = LoggerFactory.getLogger(EvaluationDaoImplTest.class.getName());

    private Evaluation getEvaluation(Evaluation e) {
        return dao.getOneByMark("evaluationid", Integer.toString(e.getId()));
    }

    /**
     * Test of create method of class EvaluationDaoImpl
     */
    @Before
    public void testCreate() {
        UserRole userRole = new UserRole("userRole");
        userRole.setId(1);
        User user = new User("email", "nickname", "password", userRole);
        user.setId(1);
        Course course = new Course("name", "description", user);
        course.setId(1);
        Task task = new Task("name", "descriprion", course);
        task.setId(1);
        evaluation = new Evaluation(10, "comment", task, user, user);
        evaluation.setId(1000);

        Assert.assertNull(getEvaluation(evaluation));
        dao.create(evaluation);
        Assert.assertNotNull(getEvaluation(evaluation));
    }

    /**
     * Test of update and get methods of class EvaluationDaoImpl.
     */
    @Test
    public void testUpdate() {
        LOG.info("test update Evaluation");
        evaluation.setComment("another comment");
        dao.update(evaluation);
        Evaluation updatedEvaluation = getEvaluation(evaluation);
        Assert.assertNotNull(updatedEvaluation);
        Assert.assertFalse(evaluation.equals(updatedEvaluation));
    }

    /**
     * Test of delete method of class EvaluationDaoImpl.
     */
    @After
    public void testDelete() {
        LOG.info("test delete Evaluation");
        Evaluation evaluationFromDao = getEvaluation(evaluation);
        Assert.assertNotNull(evaluationFromDao);
        dao.delete(evaluationFromDao);
        Assert.assertNull(getEvaluation(evaluation));
    }
}
