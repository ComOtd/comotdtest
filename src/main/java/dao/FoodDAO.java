package dao;

import entity.Food;

import java.sql.SQLException;


public interface FoodDAO extends GenericDao<Food, Long> {
    Food getByName(String name) throws SQLException;
}
