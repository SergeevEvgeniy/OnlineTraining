package com.sergeev.onlinetraining.model;

/**
 *
 * @author sea
 */
public class Task {

    private int id;
    private String name;
    private String descriprion;

    public Task(String name, String descriprion) {
        this.name = name;
        this.descriprion = descriprion;
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

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

}
