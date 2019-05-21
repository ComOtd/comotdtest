package entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dish extends AbstractIdentifiableObject{

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "RECEPT",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "composition_id"))
    Set<Composition> compositions = new HashSet<>();

    public void addComposition(Composition composition){
        compositions.add(composition);
    }

    public void removeComposition(Composition composition){
        compositions.remove(composition);
    }

    @Override
    public String toString() {
           return "Dish{" +
                ", name='" + name + '\'' +
                ", composition=" + compositions +
                '}';
    }
}
