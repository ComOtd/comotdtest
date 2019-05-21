package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Food extends AbstractIdentifiableObject{

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private double proteins;

    @Getter
    @Setter
    private double fats;

    @Getter
    @Setter
    private double carbohydrates;

    @Getter
    @Setter
    private double calories;

    @Getter
    @Setter
    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name="CATEGORY")
    private Category category;

    @Override
    public String toString() {
        return "Food{" +
                ", name='" + name + '\'' +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                ", calories=" + calories +
                ", category=" + category.getName() +
                '}';
    }
}
