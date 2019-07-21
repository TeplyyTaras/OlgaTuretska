package teplyy.taras.olgaglass.dto.request;

import lombok.Getter;
import lombok.Setter;
import teplyy.taras.olgaglass.entity.ProductForOrder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class OrderRequest {

    @NotNull
    private String phoneNumber;
    private String email;
    private String address;
    private String comment;
    private String carrier;
    private String packing;



    @NotEmpty
    private List<ProductForOrderRequest> products;
}
