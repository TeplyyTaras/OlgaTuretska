package teplyy.taras.olgaglass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teplyy.taras.olgaglass.dto.response.CartResponse;
import teplyy.taras.olgaglass.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;


    @GetMapping
    public List<CartResponse> findAll() {
        return cartService.findAll();
    }
}
