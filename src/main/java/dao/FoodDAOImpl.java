package dao;

import entity.Food;

import java.sql.SQLException;

public class FoodDAOImpl extends GenericDaoHibernateImpl<Food, Long> implements FoodDAO {

    public FoodDAOImpl(Class<Food> entityClass) {
        super(entityClass);
    }

    @Override
    public Food getByName(String name) throws SQLException {
        Food food = (Food) entityManager.createQuery("SELECT f FROM Food f WHERE f.name =:name").setParameter("name", name).getSingleResult();
        return food;
    }
}
