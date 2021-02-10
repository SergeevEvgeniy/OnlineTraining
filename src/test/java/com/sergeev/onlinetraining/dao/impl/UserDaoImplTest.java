package com.sergeev.onlinetraining.dao.impl;

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
public class UserDaoImplTest {

    private final UserDaoImpl dao = new UserDaoImpl();
    private User user;
    private static final Logger LOG = LoggerFactory.getLogger(UserDaoImplTest.class.getName());

    private User getUser(User u) {
        return dao.getOneByMark("userid", Integer.toString(u.getId()));
    }

    /**
     * Test of create method of class UserDaoImpl
     */
    @Before
    public void testCreate() {
        UserRole userRole = new UserRole("userRole");
        userRole.setId(1);

        user = new User("email", "nickname", "password", userRole);
        user.setId(1000);

        Assert.assertNull(getUser(user));
        dao.create(user);
        Assert.assertNotNull(getUser(user));
    }

    /**
     * Test of update and get methods of class UserDaoImpl.
     */
    @Test
    public void testUpdate() {
        LOG.info("test update User");
        user.setNickname("another nickname");
        dao.update(user);
        User updatedUser = getUser(user);
        Assert.assertNotNull(updatedUser);
        Assert.assertFalse(user.equals(updatedUser));
    }

    /**
     * Test of delete method of class UserDaoImpl.
     */
    @After
    public void testDelete() {
        LOG.info("test delete User");
        User userFromDao = getUser(user);
        Assert.assertNotNull(userFromDao);
        dao.delete(userFromDao);
        Assert.assertNull(getUser(user));
    }
}
