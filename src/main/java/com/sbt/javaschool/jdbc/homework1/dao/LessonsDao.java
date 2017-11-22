package com.sbt.javaschool.jdbc.homework1.dao;
import com.sbt.javaschool.jdbc.homework1.entities.Lessons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class LessonsDao extends AbstractController<Lessons> {
    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM SCHEDULE.Lessons WHERE id = ?";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LECTION_NAME = "lection_name";
    public static final String COLUMN_DATE = "date";

    @Override
    public Lessons getById(Integer id) {
        try (Connection connection = connectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Lessons(resultSet.getInt(COLUMN_ID),
                            resultSet.getString(COLUMN_LECTION_NAME),
                            resultSet.getDate(COLUMN_DATE));
                }
            }
        } catch (Exception e) {
            throw new DaoException(String.format("Method getById(id: '%d') has thrown an exception.", id), e);
        }
        return null;
    }

    @Override
    public void insert(Lessons obj) {

    }

    @Override
    public List<Lessons> getAll() {
        return null;
    }

    @Override
    public void update(Lessons obj) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void deleteAll() {

    }

}
