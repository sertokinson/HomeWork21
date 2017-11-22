package com.sbt.javaschool.jdbc.homework1.impl;

import com.sbt.javaschool.jdbc.homework1.api.StudentVisits;
import com.sbt.javaschool.jdbc.homework1.dao.AbstractController;
import com.sbt.javaschool.jdbc.homework1.dao.LessonsDao;
import com.sbt.javaschool.jdbc.homework1.dao.StudentsDao;
import com.sbt.javaschool.jdbc.homework1.entities.Lessons;
import com.sbt.javaschool.jdbc.homework1.entities.Students;

public class StudentVisitsImpl implements StudentVisits {
    Integer student_id;
    Integer lesson_id;
    AbstractController<Students> studentsDao=new StudentsDao();
    AbstractController<Lessons> lessonsDao=new LessonsDao();


    @Override
    public void visitEditing(Integer student_id, Integer lesson_id) {

    }

    @Override
    public void getStatisticById(Integer student_id) {


    }

    @Override
    public void getAllStatistic() {

    }
}
