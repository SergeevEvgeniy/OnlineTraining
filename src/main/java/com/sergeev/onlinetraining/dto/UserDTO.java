package com.sergeev.onlinetraining.dto;

import com.sergeev.onlinetraining.model.User;

/**
 *
 * @author sea
 */
public class UserDTO {

    private final User user;

    public UserDTO(User user) {
        this.user = user;
    }

    public Boolean isAdmin() {
        return "admin".equals(user.getUserRole().getUserRole());
    }
}
