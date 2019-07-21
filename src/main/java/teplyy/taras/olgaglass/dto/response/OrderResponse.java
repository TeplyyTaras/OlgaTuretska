package teplyy.taras.olgaglass.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import teplyy.taras.olgaglass.entity.Order;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class OrderResponse {

    private Long id;

    private String phoneNumber;

    private String email;

    private String address;

    private String comment;

    private String carrier;

    private String packing;

    private Long sum;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime posted;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime done;

    @JsonProperty("products")
    private List<ProductForOrderResponse> productForOrderResponses;

    public OrderResponse(Order order) {
        id = order.getId();
        phoneNumber = order.getPhoneNumber();
        email = order.getEmail();
        address = order.getAddress();
        comment = order.getComment();
        packing = order.getPacking();
        carrier = order.getCarrier();
//        posted = order.getPosted();
//        done = order.getDone();
        productForOrderResponses = order.getProductsForOrder().stream().map(ProductForOrderResponse::new)
                .collect(Collectors.toList());
    }
}

