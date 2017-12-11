package com.sbt.javaschool.jdbc.homework1.dao;
import com.sbt.javaschool.jdbc.homework1.entities.Lesson;
import com.sbt.javaschool.jdbc.homework1.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LessonsDao extends AbstractController<Lesson> {
    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM SCHEDULE.LESSONS WHERE id = ?";
    public static final String INSERT_INTO_QUERY ="INSERT INTO SCHEDULE.LESSONS (lection_name,date)\n" + "VALUES (?, ?);\n";
    public static final String SELECT_ALL_QUERY = "SELECT * FROM SCHEDULE.LESSONS";
    public static final String UPDATE_QUERY = "UPDATE SCHEDULE.LESSONS SET lection_name = ?, date = ? WHERE id=?";
    public static final String DELETE_BY_ID_QUERY = "DELETE FROM SCHEDULE.LESSONS WHERE ID=?";
    public static final String DELETE_ALL_QUERY = "DELETE * FROM SCHEDULE.LESSONS ";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LECTION_NAME = "lection_name";
    public static final String COLUMN_DATE = "date";

    @Override
    public Lesson getById(Integer id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Lesson(resultSet.getInt(COLUMN_ID),
                            resultSet.getString(COLUMN_LECTION_NAME),
                            resultSet.getDate(COLUMN_DATE),resultSet.getTime(COLUMN_DATE));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getById(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }

    @Override
    public void insert(Lesson obj) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_INTO_QUERY)) {
            statement.setString(1, obj.getLection_name());
            statement.setDate(2, obj.getDate());
            statement.execute();
        } catch (Exception e) {
            throw new DaoException("Method insert(obj) has thrown an exception", e);
        }

    }

    @Override
    public List<Lesson> getAll() {
        List<Lesson> lessons = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    lessons.add(new Lesson(resultSet.getInt(COLUMN_ID),
                            resultSet.getString(COLUMN_LECTION_NAME),
                            resultSet.getDate(COLUMN_DATE),resultSet.getTime(COLUMN_DATE)));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getAll() has thrown an exception."), e);
        }
        return lessons;
    }

    @Override
    public void update(Lesson obj) {

        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, obj.getLection_name());
            statement.setDate(2, obj.getDate());
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
