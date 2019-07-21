package teplyy.taras.olgaglass.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teplyy.taras.olgaglass.dto.request.OrderRequest;
import teplyy.taras.olgaglass.dto.request.OrderSearchRequest;
import teplyy.taras.olgaglass.dto.response.OrderResponse;
import teplyy.taras.olgaglass.dto.response.PageResponse;
import teplyy.taras.olgaglass.service.OrderService;

import javax.validation.Valid;

import static teplyy.taras.olgaglass.tool.Constants.ORDER_URL;

@CrossOrigin
@RestController
@RequestMapping(ORDER_URL)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public void create(@Valid @RequestBody OrderRequest orderRequest) {
        orderService.save(orderRequest);
    }

//    @GetMapping // потрібна доробка специфікації
//    public PageResponse<OrderResponse> findAll(OrderSearchRequest request) {
//        return orderService.findAll(request);
//    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody OrderRequest orderRequest) {
        orderService.update(id, orderRequest);
    }

//    @PutMapping("/archive")
//    public void archive(Long id) {
//        orderService.archive(id);
//    }
//
//    @PutMapping("/unarchive")
//    public void unarchive(Long id) {
//        orderService.unarchive(id);
//    }

    @DeleteMapping
    public void delete(Long id) {
        orderService.delete(id);
    }
}
