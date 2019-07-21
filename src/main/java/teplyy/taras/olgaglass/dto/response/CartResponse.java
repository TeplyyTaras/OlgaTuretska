package teplyy.taras.olgaglass.dto.response;

import lombok.Getter;
import lombok.Setter;
import teplyy.taras.olgaglass.entity.Cart;

@Getter
@Setter
public class CartResponse {

    private Long id;


    public CartResponse (Cart cart) { //робимо звичайний конструктор куди передаєм категорі як ентіті
        id = cart.getId();

    }
}
