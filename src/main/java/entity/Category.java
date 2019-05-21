package entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
public class Category extends AbstractIdentifiableObject{

    @Getter
    @Setter
    String name;

    @Getter
    @OneToMany(mappedBy="category", cascade=CascadeType.ALL)
    List<Food> foods;

    @Override
    public String toString() {
        return "Category{" +
                ", name='" + name + '\'' +
                '}';
    }
}
