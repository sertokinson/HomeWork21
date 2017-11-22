package com.sbt.javaschool.jdbc.homework1.api;

public interface StudentVisits {
    void visitEditing(Integer student_id,Integer lesson_id);
    void getStatisticById(Integer student_id);
    void getAllStatistic();
}
