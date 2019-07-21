package teplyy.taras.olgaglass.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.scene.control.Pagination;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class OrderSearchRequest {

    private String value;
    private Long minSum;
    private Long maxSum;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime dateFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime dateTo;

    @JsonProperty("pagination")
    private PaginationRequest paginationRequest;


}
