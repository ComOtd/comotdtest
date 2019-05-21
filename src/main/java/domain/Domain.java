package domain;
import dao.FoodDAOImpl;
import dao.GenericDaoHibernateImpl;
import entity.Category;
import entity.Composition;
import entity.Dish;
import entity.Food;
import lombok.Getter;
import lombok.Setter;


import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Domain {
    public static void main(String[] args) throws SQLException{

        GenericDaoHibernateImpl<Category, Long> categoryDAO = new GenericDaoHibernateImpl<>(Category.class);
        FoodDAOImpl foodDAO = new FoodDAOImpl(Food.class);
        GenericDaoHibernateImpl<Dish, Long> dishDAO = new GenericDaoHibernateImpl<>(Dish.class);
        GenericDaoHibernateImpl<Composition, Long> compositionDAO = new GenericDaoHibernateImpl<>(Composition.class);

        Composition composition = compositionDAO.get((long) 1);
        composition.setWeight(200);
//        Composition composition2 = new Composition(foodDAO.getByName("Помидор"), 100);
//        Set<Composition> compositions = new HashSet<>();
//        compositions.add(composition);
//        compositions.add(composition2);
//        Dish dish = new Dish("Салат из огурцов и помидоров", compositions);
//        dishDAO.save(dish);
        compositionDAO.update(composition);
        System.out.println(dishDAO.getAll());

    }
}
