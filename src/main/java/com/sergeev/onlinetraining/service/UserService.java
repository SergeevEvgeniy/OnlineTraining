package com.sergeev.onlinetraining.service;

import com.sergeev.onlinetraining.dao.CRUDdao;
import com.sergeev.onlinetraining.dao.impl.SubscriptionDaoImpl;
import com.sergeev.onlinetraining.dao.impl.UserDaoImpl;
import com.sergeev.onlinetraining.dao.impl.UserRoleDaoImpl;
import com.sergeev.onlinetraining.model.Subscription;
import com.sergeev.onlinetraining.model.User;
import com.sergeev.onlinetraining.model.UserRole;
import java.util.List;

/**
 *
 * @author sea
 */
public class UserService {

    private final CRUDdao<User> dao = new UserDaoImpl();
    private final CRUDdao<UserRole> roleDao = new UserRoleDaoImpl();
    private final CRUDdao<Subscription> subDao = new SubscriptionDaoImpl();

    public User getByEmail(String email) {
        return dao.getOneByMark("email", email);
    }

    public List<User> getLectors() {
        final UserRole lectorRole = roleDao.getOneByMark("userrole", "lector");
        return dao.getAllByMark("userroleid", Integer.toString(lectorRole.getId()));
    }

    public List<User> getStudents() {
        final UserRole lectorRole = roleDao.getOneByMark("userrole", "student");
        return dao.getAllByMark("userroleid", Integer.toString(lectorRole.getId()));
    }

    public User getById(String param) {
        return dao.getOneByMark("userId", param);
    }

    public List<Subscription> getSubscriptions(User user) {
        return subDao.getAllByMark("userid", Integer.toString(user.getId()));
    }
}
