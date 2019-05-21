package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Category extends AbstractIdentifiableObject{

    @Getter
    @Setter
    private String name;

    @Override
    public String toString() {
        return "Category{" +
                ", name='" + name + '\'' +
                '}';
    }
}
