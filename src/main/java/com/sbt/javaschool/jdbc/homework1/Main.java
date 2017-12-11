package com.sbt.javaschool.jdbc.homework1;

import com.sbt.javaschool.jdbc.homework1.dao.AbstractController;
import com.sbt.javaschool.jdbc.homework1.dao.LessonsDao;
import com.sbt.javaschool.jdbc.homework1.dao.StudentVisitsDao;
import com.sbt.javaschool.jdbc.homework1.dao.StudentsDao;
import com.sbt.javaschool.jdbc.homework1.entities.Lesson;
import com.sbt.javaschool.jdbc.homework1.entities.StudentVisits;
import com.sbt.javaschool.jdbc.homework1.entities.Student;


public class Main {
        public static void main(String[] args) {
            StudentVisitsDao studentVisits = new StudentVisitsDao();
            //studentVisits.insert(1,4);
           // studentVisits.getAll();
          //  studentVisits.update(6,3,4);
            studentVisits.getAll();
            //studentVisits.deleteById(6);
          /*  studentVisits.deleteById(7);
            studentVisits.deleteById(8);*/
           /* for (Student s:studentVisits.getAll().keySet()) {
                System.out.println(s);
            }*/




        }
    }
