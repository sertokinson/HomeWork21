package com.sbt.javaschool.jdbc.homework1.dao;

import com.sbt.javaschool.jdbc.homework1.entities.Lessons;
import com.sbt.javaschool.jdbc.homework1.entities.StudentVisits;
import com.sbt.javaschool.jdbc.homework1.entities.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class StudentVisitsDao extends AbstractController<StudentVisits> {
    public static final String INSERT_INTO_QUERY ="INSERT INTO SCHEDULE.STUDENT_VISITS\n" +
            "VALUES (?, ?);\n";
    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM SCHEDULE.STUDENT_VISITS WHERE id = ?";
    public static final String COLUMN__STUDENT_ID = "student_id";
    public static final String COLUMN_LESSON_ID = "lesson_id";
    private AbstractController<Students> students = new StudentsDao();
    private AbstractController<Lessons> lessons = new LessonsDao();

    @Override
    public StudentVisits getById(Integer id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new StudentVisits(students.getById(resultSet.getInt(COLUMN__STUDENT_ID))
                            ,lessons.getById(resultSet.getInt(COLUMN_LESSON_ID)));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getById(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }

    @Override
    public void insert(StudentVisits obj) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO_QUERY)) {
            statement.setInt(1, obj.getStudents().getId());
            statement.setInt(2, obj.getLessons().getId());
            statement.execute();
        } catch (Exception e) {
            throw new DaoException("Method insert(obj) has thrown an exception", e);
        }

    }

    @Override
    public List<StudentVisits> getAll() {
        return null;
    }

    @Override
    public void update(StudentVisits obj) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void deleteAll() {

    }
}
