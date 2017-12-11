package com.sbt.javaschool.jdbc.homework1.entities;

import java.sql.Date;
import java.sql.Time;

public class Lesson {
    private Integer id;
    private String lection_name;
    private Date date;
    private Time time;

    public Time getTime() {
        return time;
    }

    public Lesson(Integer id, String lection_name, Date date,Time time) {
        this.id = id;
        this.lection_name = lection_name;
        this.date = date;
        this.time=time;
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
        return "Lesson{" +
                "id=" + id +
                ", lection_name='" + lection_name + '\'' +
                ", date=" + date +
                '}';
    }
}
