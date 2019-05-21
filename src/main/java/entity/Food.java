package entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
public class Food extends AbstractIdentifiableObject{


    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    double proteins;

    @Getter
    @Setter
    double fats;

    @Getter
    @Setter
    double carbohydrates;

    @Getter
    @Setter
    double calories;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    Category category;

    @OneToMany(mappedBy="food", cascade=CascadeType.ALL)
    Set<Composition> compositions;

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
