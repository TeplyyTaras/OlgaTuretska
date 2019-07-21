package teplyy.taras.olgaglass.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import teplyy.taras.olgaglass.entity.Product;

import java.util.List;

@Getter
@Setter
public class ProductResponse {

    private Long id;

    private String name;

    private Double height;

    private Double wight;

    private Double deapt;

    private Double diameter;

    private String description;

    private Integer price;

    private Double weight;

    @JsonProperty("subcategory")
    private SubcategoryResponse subcategoryResponse; //вкладений обєкт

    private List<String> images;

    public ProductResponse(Product product) {
        id = product.getId();
        name = product.getName();
        height = product.getHeight();
        wight = product.getWight();
        deapt = product.getDeapt();
        description = product.getDescription();
        weight = product.getWeight();
        diameter = product.getDiameter();
        price = product.getPrice();
        subcategoryResponse = new SubcategoryResponse(product.getSubcategory());

        images = product.getImages();
    }
}
