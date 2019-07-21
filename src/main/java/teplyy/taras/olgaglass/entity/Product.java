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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double height;

    private Double wight;

    private Double deapt;

    private Double diameter;

    private String description;

    private Integer price;

    private Double weight;

    @ElementCollection
    private List<String> images = new ArrayList<>();

    @ManyToOne
    private Subcategory subcategory;

    @ManyToMany(mappedBy = "products")
    private List<Cart> carts = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    private List<Order> orders = new ArrayList<>();

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Height=" + height +
                ", Wight=" + wight +
                ", Wight=" + diameter +
                ", Deapt=" + deapt +
                ", Descrption='" + description + '\'' +
                ", price=" + price +
                ", Weight=" + weight +
                '}';
    }
}
