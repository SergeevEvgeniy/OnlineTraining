package com.sergeev.onlinetraining.model;

/**
 *
 * @author sea
 */
public class Evaluation {

    private int id;
    private int grade;
    private String comment;
    private Task task;
    private User student;
    private User lector;

    public Evaluation(int grade, String comment, Task task, User student, User lector) {
        this.grade = grade;
        this.comment = comment;
        this.task = task;
        this.student = student;
        this.lector = lector;
    }

    public Evaluation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public User getLector() {
        return lector;
    }

    public void setLector(User lector) {
        this.lector = lector;
    }

}
