package domain;
import dao.FoodDAOImpl;
import dao.GenericDaoHibernateImpl;
import entity.Category;
import entity.Composition;
import entity.Dish;
import entity.Food;


import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import static bl.HibernateUtil.getEm;

public class Domain {
    public static void main(String[] args) throws SQLException{

        EntityManager entityManager = getEm();
        entityManager.getTransaction().begin();



        Category category = new Category();
        category.setName("Овощи");

        entityManager.persist(category);
        entityManager.getTransaction().commit();
        entityManager.close();

        Food food = new Food();
        food.setName("Помидор");
        food.setCalories(200);
        food.setCarbohydrates(10);
        food.setCategory(category);
        food.setFats(0);
        food.setProteins(0);

        Food food2 = new Food();
        food2.setName("Огурец");
        food2.setCalories(100);
        food2.setCarbohydrates(20);
        food2.setCategory(category);
        food2.setFats(0);
        food2.setProteins(0);

        Composition composition = new Composition();
        composition.setWeight(300);
        composition.setFood(food);
        Composition composition2 = new Composition();
        composition2.setWeight(150);
        composition2.setFood(food2);


        Dish dish = new Dish();
        Set<Composition> c = new HashSet<Composition>();
        c.add(composition);
        c.add(composition2);
        dish.setComposition(c);
        dish.setName("Салат");


        System.out.println(category);
        System.out.println(food);
        System.out.println(dish);
        System.out.println(composition);


        GenericDaoHibernateImpl<Food, Long> foodDAO = new GenericDaoHibernateImpl <>(Food.class);
        foodDAO.save(food);
        foodDAO.save(food2);
        List<Food> foods = foodDAO.getAll();

        System.out.println(Arrays.toString(foods.toArray()));



//        entityManager.persist(composition);

//        entityManager.persist(food);
//        entityManager.persist(food2);
//        entityManager.persist(dish);


    }
}
