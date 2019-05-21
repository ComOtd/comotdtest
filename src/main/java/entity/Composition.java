package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Composition extends AbstractIdentifiableObject{

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Food.class, cascade=CascadeType.ALL)
    @JoinColumn(name="FOOD_ID")
    private Food food;

    @Override
    public String toString() {
        return "Composition{" +
                ", food name=" + food.getName() +
                ", weight=" + weight +
                '}';
    }

    @Getter
    @Setter
    private double weight;
}
