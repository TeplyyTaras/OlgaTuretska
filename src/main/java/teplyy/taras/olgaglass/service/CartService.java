package teplyy.taras.olgaglass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teplyy.taras.olgaglass.dto.response.CartResponse;

import teplyy.taras.olgaglass.reposotory.CartRepositiry;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepositiry cartRepositiry;

    public List<CartResponse> findAll() {
        return cartRepositiry.findAll().stream() //ліст категорій
                .map(CartResponse::new) // перетворення з допомогою конструктора
                .collect(Collectors.toList()); // збір докупи і відповідь
    }
}
