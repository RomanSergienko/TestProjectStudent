package me.sergienko.model;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "sur_name")
    private String surName;

    @Column(name = "group_id")
    private int groupId;

    @Column(name = "enrolment_date")
    private Date enrolmentDate;

    @Column(name = "exam_result")
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