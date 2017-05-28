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

    public double getRating_ege() {
        return ratingEge;
    }

    public void setRating_ege(double rating_ege) {
        this.ratingEge = rating_ege;
    }

    public String getName() {
        return name;
    }

    public String getSur_name() {
        return surName;
    }

    public int getGroup_id() {
        return groupId;
    }

    public Date getEnrolment_date() {
        return enrolmentDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSur_name(String sur_name) {
        this.surName = sur_name;
    }

    public void setGroup_id(int group_id) {
        this.groupId = group_id;
    }

    public void setEnrolment_date(Date enrolment_date) {
        this.enrolmentDate = enrolment_date;
    }
}
