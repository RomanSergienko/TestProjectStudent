package me.sergienko.model;

import java.util.Date;


public class Student {
    private int id;
    private String name;
    private String surName;
    private int groupId;
    private Date enrolmentDate;
    private double ratingEge;

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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Date getEnrolmentDate() {
        return enrolmentDate;
    }

    public void setEnrolmentDate(Date enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }

    public double getRatingEge() {
        return ratingEge;
    }

    public void setRatingEge(double ratingEge) {
        this.ratingEge = ratingEge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", groupId=" + groupId +
                ", enrolmentDate=" + enrolmentDate +
                ", ratingEge=" + ratingEge +
                '}';
    }
}