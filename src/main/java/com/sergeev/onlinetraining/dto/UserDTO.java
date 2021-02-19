package com.sergeev.onlinetraining.dto;

import com.sergeev.onlinetraining.model.Subscription;
import com.sergeev.onlinetraining.model.User;
import com.sergeev.onlinetraining.service.UserService;
import java.util.List;

/**
 *
 * @author sea
 */
public class UserDTO {

    private final User user;
    private final UserService us = new UserService();

    public UserDTO(User user) {
        this.user = user;
    }

    public Boolean isAdmin() {
        return "admin".equals(user.getUserRole().getUserRole());
    }

    public Boolean isLector() {
        return "lector".equals(user.getUserRole().getUserRole());
    }

    public Boolean isStudent() {
        return "student".equals(user.getUserRole().getUserRole());
    }

    public Boolean isSubscribed(Integer courseId) {
        final List<Subscription> subscriptions = getSubscriptions();
        for (Subscription subscription : subscriptions) {
            if (subscription.getCourseId() == courseId) {
                return true;
            }
        }
        return false;
    }

    public List<Subscription> getSubscriptions() {
        return us.getSubscriptions(user);
    }

    public User getUser() {
        return user;
    }
}
