package teplyy.taras.olgaglass.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import teplyy.taras.olgaglass.entity.Product;
import teplyy.taras.olgaglass.entity.Subcategory;

@Getter
@Setter

public class SubcategoryResponse {

    private Long id;

    private String name;

    private String image;

    @JsonProperty("category")

    private CategoryResponse categoryResponse; //вкладений обєкт

    public SubcategoryResponse(Subcategory subcategory) {
        id = subcategory.getId();
        name = subcategory.getName();
        image = subcategory.getImage();
        categoryResponse = new CategoryResponse(subcategory.getCategory());
    }
}
