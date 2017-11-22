package com.sbt.javaschool.jdbc.homework1.dao;
import com.sbt.javaschool.jdbc.homework1.entities.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class StudentsDao extends AbstractController<Students> {
    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM SCHEDULE.STUDENTS WHERE id = ?";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_AGE = "age";

    @Override
    public Students getById(Integer id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
             statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Students(resultSet.getInt(COLUMN_ID),
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
    public void insert(Students obj) {

    }

    @Override
    public List<Students> getAll() {
        return null;
    }

    @Override
    public void update(Students obj) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void deleteAll() {

    }

}
