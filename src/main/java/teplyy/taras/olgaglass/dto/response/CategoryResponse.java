package teplyy.taras.olgaglass.dto.response;

import lombok.Getter;
import lombok.Setter;
import teplyy.taras.olgaglass.entity.Category;

@Getter
@Setter
public class CategoryResponse {

    private Long id;

    private String name; // 5.08

    private String image;

    public CategoryResponse (Category category) { //робимо звичайний конструктор куди передаєм категорі як ентіті
        id = category.getId();
        name = category.getName();
        image = category.getImage();
    }
}
