package com.sbt.javaschool.jdbc.homework1.entities;

import java.util.Date;

public class Lessons {
    private Integer id;
    private String lection_name;
    private Date date;

    public Lessons(Integer id, String lection_name, Date date) {
        this.id = id;
        this.lection_name = lection_name;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLection_name() {
        return lection_name;
    }

    public void setLection_name(String lection_name) {
        this.lection_name = lection_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                "id=" + id +
                ", lection_name='" + lection_name + '\'' +
                ", date=" + date +
                '}';
    }
}
