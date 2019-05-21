package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Dish extends AbstractIdentifiableObject{
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.EAGER, targetEntity = Composition.class, cascade=CascadeType.ALL)
    @JoinColumn(name="DISH_ID")
    private Set<Composition> composition;

    @Override
    public String toString() {
           return "Dish{" +
                ", name='" + name + '\'' +
                ", composition=" + composition.stream().map(Composition :: getFood).map(Food :: getName).collect(Collectors.joining(", ")) +
                '}';
    }
}
