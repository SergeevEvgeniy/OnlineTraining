package com.sergeev.onlinetraining.model;

/**
 *
 * @author sea
 */
public class User {

    private int id;
    private String email;
    private String login;
    private String password;
    private UserRole userRole;

    public User(String email, String login, String password, UserRole userRole) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

}
