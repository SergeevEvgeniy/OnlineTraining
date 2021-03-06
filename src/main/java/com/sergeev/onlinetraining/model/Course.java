package com.sergeev.onlinetraining.model;

import java.util.List;

/**
 *
 * @author sea
 */
public class Course {

    private int id;
    private String name;
    private String description;
    private User lector;
    private List<User> students;
    private List<Task> tasks;

    public Course(String name, String description, User lector) {
        this.name = name;
        this.description = description;
        this.lector = lector;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getLector() {
        return lector;
    }

    public void setLector(User lector) {
        this.lector = lector;
    }

    public List<User> getStudents() {
        return students;
    }

    public void setStudents(List<User> subscribers) {
        this.students = subscribers;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        return this.id == other.id;
    }

}
