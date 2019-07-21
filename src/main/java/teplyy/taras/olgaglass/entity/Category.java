package teplyy.taras.olgaglass.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    @OneToMany(mappedBy = "category")
    private List<Subcategory> subcategories = new ArrayList<>();

    @Override
    public String toString() {
        return "CategoryRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
