package teplyy.taras.olgaglass.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity

public class ProductForOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Order order;
}
