package teplyy.taras.olgaglass.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter

public class ReviewRequest {

    @NotNull
    private String userName;

    @NotNull
    private String text;

    @NotNull
    private Long productId;

    private Boolean show; // ????

}
