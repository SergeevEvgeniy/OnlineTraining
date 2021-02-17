package com.sergeev.onlinetraining.service;

import com.sergeev.onlinetraining.dao.CRUDdao;
import com.sergeev.onlinetraining.dao.impl.UserDaoImpl;
import com.sergeev.onlinetraining.model.User;

/**
 *
 * @author sea
 */
public class UserService {

    private final CRUDdao<User> dao = new UserDaoImpl();

    public User getByEmail(String email) {
        return dao.getOneByMark("email", email);
    }
}
