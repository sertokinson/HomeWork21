package com.sbt.javaschool.jdbc.homework1.dao;

import com.sbt.javaschool.jdbc.homework1.ConnectionFactory;
import com.sbt.javaschool.jdbc.homework1.entities.Lesson;
import com.sbt.javaschool.jdbc.homework1.entities.Student;
import com.sbt.javaschool.jdbc.homework1.entities.StudentVisits;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class StudentVisitsDao {
    public static final String INSERT_INTO_QUERY = "INSERT INTO SCHEDULE.STUDENT_VISITS (student_id,lesson_id)\n" +
            "VALUES (?, ?);\n";
    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM SCHEDULE.STUDENT_VISITS WHERE student_id = ?";
    public static final String SELECT_ALL_QUERY = "SELECT * FROM SCHEDULE.STUDENT_VISITS";
    public static final String UPDATE_QUERY = "UPDATE SCHEDULE.STUDENT_VISITS SET student_id = ?, lesson_id = ? WHERE id=?";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM SCHEDULE.STUDENT_VISITS WHERE ID=?";
    public static final String DELETE_ALL_QUERY = "DELETE * FROM SCHEDULE.STUDENT_VISITS ";
    public static final String COLUMN_STUDENT_ID = "student_id";
    public static final String COLUMN_LESSON_ID = "lesson_id";
    private AbstractController<Student> studentDao = new StudentsDao();
    private AbstractController<Lesson> lessonDao = new LessonsDao();
    public ConnectionFactory connectionFactory;

    public StudentVisitsDao() {
        this.connectionFactory = ConnectionFactory.getInstance();
    }

    public void getById(Integer id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                resultSet.next();
                Student student = studentDao.getById(id);
                Lesson lesson = lessonDao.getById(resultSet.getInt(COLUMN_LESSON_ID));
                System.out.println("Студент " + student.getFirst_name() + " " + student.getLast_name() + " посятил(а): ");
                System.out.println(lesson.getLection_name() + " в " + lesson.getTime() + " " + lesson.getDate());
                while (resultSet.next()) {
                    lesson = lessonDao.getById(resultSet.getInt(COLUMN_LESSON_ID));
                    System.out.println(lesson.getLection_name() + " в " + lesson.getTime() + " " + lesson.getDate());
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getById(id: '%d') has thrown an exception.", id), e);
        }
    }

    public void insert(StudentVisits obj) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO_QUERY)) {
            statement.setInt(1, obj.getStudent().getId());
            statement.setInt(2, obj.getLesson().getId());
            statement.execute();
        } catch (Exception e) {
            throw new DaoException("Method insert(obj) has thrown an exception", e);
        }

    }

    public void insert(int studentId, int lessonId) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO_QUERY)) {
            statement.setInt(1, studentId);
            statement.setInt(2, lessonId);
            statement.execute();
        } catch (Exception e) {
            throw new DaoException("Method insert(obj) has thrown an exception", e);
        }

    }


    public void getAll() {
        Set<Student> students = new HashSet<>();
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    students.add(studentDao.getById(resultSet.getInt(COLUMN_STUDENT_ID)));
                }
                for (Student s : students) {
                    getById(s.getId());
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getAll() has thrown an exception."), e);
        }
    }

    public void update(int id, int student_id, int lesson_id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, student_id);
            statement.setInt(2, lesson_id);
            statement.setInt(3, id);
            statement.execute();
        } catch (Exception e) {
            throw new DaoException("Method insert(obj) has thrown an exception", e);
        }

    }

    public void deleteById(int id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID_QUERY)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception e) {
            throw new DaoException(String.format("Method deleteById(id: '%d') has thrown an exception.", id), e);
        }
    }

    public void deleteAll() {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ALL_QUERY)) {
            statement.execute();
        } catch (Exception e) {
            throw new DaoException(String.format("Method getAll() has thrown an exception."), e);

        }
    }
}
