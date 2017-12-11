package com.sbt.javaschool.jdbc.homework1.dao;
import com.sbt.javaschool.jdbc.homework1.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentsDao extends AbstractController<Student> {
    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM SCHEDULE.STUDENTS WHERE id = ?";
    public static final String INSERT_INTO_QUERY ="INSERT INTO SCHEDULE.STUDENTS (first_name,last_name,age)\n" + "VALUES (?, ?, ?);\n";
    public static final String SELECT_ALL_QUERY = "SELECT * FROM SCHEDULE.STUDENTS";
    public static final String UPDATE_QUERY = "UPDATE SCHEDULE.STUDENTS SET first_name = ?, last_name = ?, age = ? WHERE id=?";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM SCHEDULE.STUDENTS WHERE ID=?";
    public static final String DELETE_ALL_QUERY = "DELETE * FROM SCHEDULE.STUDENTS ";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_AGE = "age";


    @Override
    public Student getById(Integer id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
             statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Student(resultSet.getInt(COLUMN_ID),
                            resultSet.getString(COLUMN_FIRST_NAME),
                            resultSet.getString(COLUMN_LAST_NAME),
                            resultSet.getInt(COLUMN_AGE));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getById(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }

    @Override
    public void insert(Student obj) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO_QUERY)) {
            statement.setString(1, obj.getFirst_name());
            statement.setString(2, obj.getLast_name());
            statement.setInt(3, obj.getAge());
            statement.execute();
        } catch (Exception e) {
            throw new DaoException("Method insert(obj) has thrown an exception", e);
        }
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                     students.add(new Student(resultSet.getInt(COLUMN_ID),
                             resultSet.getString(COLUMN_FIRST_NAME),
                             resultSet.getString(COLUMN_LAST_NAME),
                             resultSet.getInt(COLUMN_AGE)));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getAll() has thrown an exception."), e);
        }
        return students;
    }

    @Override
    public void update(Student obj) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, obj.getFirst_name());
            statement.setString(2, obj.getLast_name());
            statement.setInt(3, obj.getAge());
            statement.setInt(4, obj.getId());
            statement.execute();
        } catch (Exception e) {
            throw new DaoException("Method insert(obj) has thrown an exception", e);
        }
    }

    @Override
    public void deleteById(int id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID_QUERY)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (Exception e) {
            throw new DaoException(String.format("Method deleteById(id: '%d') has thrown an exception.", id), e);
        }
    }

    @Override
    public void deleteAll() {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ALL_QUERY)) {
            statement.execute();
        } catch (Exception e) {
            throw new DaoException(String.format("Method getAll() has thrown an exception."), e);
        }
    }

}
