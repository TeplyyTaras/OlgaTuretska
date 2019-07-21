package teplyy.taras.olgaglass.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter

public class ProductRequest {

    @NotNull
    private String name;

    private Double height;

    private Double wight;

    private Double deapt;

    private Double diameter;

    private String description;

    private List<String> image = new ArrayList<>();

    @NotNull
    private Integer price;

    private Double weight;

    @NotNull
    private Long SubcategryId;

    private Collection<Object> images;

    public Collection<Object> getImages() {
        return images;
    }
}
