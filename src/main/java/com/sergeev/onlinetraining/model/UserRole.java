package com.sergeev.onlinetraining.model;

/**
 *
 * @author sea
 */
public class UserRole {

    private int id;
    private String userRole;

    public UserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

}
