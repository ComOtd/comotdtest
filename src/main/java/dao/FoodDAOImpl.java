package dao;

import entity.Food;

import java.sql.SQLException;

public class FoodDAOImpl extends GenericDaoHibernateImpl<Food, Long> {

    public FoodDAOImpl(Class<Food> entityClass) {
        super(entityClass);
    }

}
