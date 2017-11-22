package com.sbt.javaschool.jdbc.homework1.dao;

import com.sbt.javaschool.jdbc.homework1.ConnectionFactory;

import java.util.List;

public abstract class AbstractController<T> {
    public ConnectionFactory connectionFactory;

    public AbstractController() {
        this.connectionFactory = ConnectionFactory.getInstance();
    }
    /**
     * Возвращает объект класса T с данными извлеченными из хранилища.
     * Для поиска используется идентификатор.
     *
     * @param id - соответствует колонке идентификаторов в БД.
     * @return объект класса T с данными.
     */
    public abstract T getById(Integer id);

    /**
     * Сохраняет объект класса T в базу данных.
     *
     * @param obj - объект класса T с данными.
     */
    public abstract void insert(T obj);

    /**
     * Возвращает список всех T.
     *
     * @return список всех T.
     */
    public abstract List<T> getAll();

    /**
     * Обновляет новую информацию об T.
     *
     * @param obj - объект класса T с данными.
     */
    public abstract void update(T obj);

    /**
     * Удаляет пользователя из базы данных по идентификатору.
     *
     * @param id - соответствует колонке идентификаторов в БД.
     */
    public abstract void deleteById(long id);

    /**
     * Удаляет всех.
     */
    public abstract void deleteAll();
}
