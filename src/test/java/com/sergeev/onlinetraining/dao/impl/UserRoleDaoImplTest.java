package com.sergeev.onlinetraining.dao.impl;

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
public class UserRoleDaoImplTest {

    private final UserRoleDaoImpl dao = new UserRoleDaoImpl();
    private UserRole userRole;
    private static final Logger LOG = LoggerFactory.getLogger(UserRoleDaoImplTest.class.getName());

    private UserRole getUserRole(UserRole ur) {
        return dao.getOneByMark("userroleid", Integer.toString(ur.getId()));
    }

    /**
     * Test of create method of class UserRoleDaoImpl
     */
    @Before
    public void testCreate() {
        userRole = new UserRole("Test UR");
        userRole.setId(1000);

        Assert.assertNull(getUserRole(userRole));
        dao.create(userRole);
        Assert.assertNotNull(getUserRole(userRole));
    }

    /**
     * Test of update and get methods of class UserRoleDaoImpl.
     */
    @Test
    public void testUpdate() {
        LOG.info("test update UserRole");
        userRole.setUserRole("another userRole");
        dao.update(userRole);
        UserRole updatedUserRole = getUserRole(userRole);
        Assert.assertNotNull(updatedUserRole);
        Assert.assertFalse(userRole.equals(updatedUserRole));
    }

    /**
     * Test of delete method of class UserRoleDaoImpl.
     */
    @After
    public void testDelete() {
        LOG.info("test delete UserRole");
        UserRole userRoleFromDao = getUserRole(userRole);
        Assert.assertNotNull(userRoleFromDao);
        dao.delete(userRoleFromDao);
        Assert.assertNull(getUserRole(userRole));
    }
}
