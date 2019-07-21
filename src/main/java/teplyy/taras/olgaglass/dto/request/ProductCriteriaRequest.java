package teplyy.taras.olgaglass.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCriteriaRequest {

    private String value;
    private Integer minPrice;
    private Integer maxPrice;
    private Long catecoryId;
    private Long subcatecoryId;

    @JsonProperty("pagination")
    private PaginationRequest paginationRequest;
}
