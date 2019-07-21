package teplyy.taras.olgaglass.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import teplyy.taras.olgaglass.entity.Review;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReviewResponse {

    private Long id;
    private String username;
    private String text;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime datePosted;
    private Boolean show;

    @JsonProperty("product")
    private ProductResponse productResponse;

    public ReviewResponse(Review review) {
        id = review.getId();
        username = review.getUserName();
        text = review.getText();
        datePosted = review.getDatePosted();
        productResponse = new ProductResponse(review.getProduct());
//        show = review.getShow();
    }
}
