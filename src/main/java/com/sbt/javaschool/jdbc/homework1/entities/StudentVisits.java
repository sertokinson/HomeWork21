package com.sbt.javaschool.jdbc.homework1.entities;

public class StudentVisits {
    Student student;
    Lesson lesson;

    public StudentVisits(Student student, Lesson lesson) {
        this.student = student;
        this.lesson = lesson;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "StudentVisits{" +
                "student=" + student +
                ", lesson=" + lesson +
                '}';
    }
}
