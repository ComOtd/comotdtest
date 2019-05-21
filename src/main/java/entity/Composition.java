package entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
public class Composition extends AbstractIdentifiableObject{

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="FOOD_ID")
    Food food;

    @ManyToMany(mappedBy = "compositions")
    Set<Dish> dishes = new HashSet<>();

    @Getter
    @Setter
    double weight;

    public Composition(Food food, double weight) {
        this.food = food;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Composition{" +
                ", food name=" + food.getName() +
                ", weight=" + weight +
                '}';
    }

}
