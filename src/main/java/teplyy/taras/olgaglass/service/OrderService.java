package teplyy.taras.olgaglass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import teplyy.taras.olgaglass.dto.request.OrderRequest;
import teplyy.taras.olgaglass.dto.request.OrderSearchRequest;
import teplyy.taras.olgaglass.dto.request.ProductForOrderRequest;
import teplyy.taras.olgaglass.dto.response.OrderResponse;
import teplyy.taras.olgaglass.dto.response.PageResponse;
import teplyy.taras.olgaglass.entity.Order;
import teplyy.taras.olgaglass.entity.ProductForOrder;
import teplyy.taras.olgaglass.reposotory.OrderRepository;
import teplyy.taras.olgaglass.reposotory.ProductForOrderRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import static teplyy.taras.olgaglass.tool.Constants.KIEV_ZONE;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductForOrderRepository productForOrderRepository; // уточнити чи треба?

    @Autowired
    private ProductService productService;

    public void save(OrderRequest orderRequest) {
        Order order = orderRepository.save(orderRequestToOrder(null, orderRequest));
        saveProductsForOrder(order, orderRequest);
    }

    public void update(Long id, OrderRequest OrderRequest) {
        Order order = orderRepository.save(orderRequestToOrder(findOne(id), OrderRequest));
        saveProductsForOrder(order, OrderRequest);
    }

    public Order findOne(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Order with id " + id + " not exists"));
    }

    public void delete(Long id) {
        Order order = findOne(id);
        orderRepository.delete(order);
    }

//    public PageResponse<OrderResponse> findAll(OrderSearchRequest request) {
//        Page<Order> page = orderRepository.findAll(new OrderSpecification(request), request.getPaginationRequest().toPageable());
//        return new PageResponse<>(page.get().map(OrderResponse::new).collect(Collectors.toList()), page.getTotalPages(), page.getTotalElements());
//    }

    private Order orderRequestToOrder(Order order, OrderRequest orderRequest) {
        if (order == null) {
            order = new Order();
            order.setPosted(LocalDateTime.now(ZoneId.of(KIEV_ZONE)));
        }
        order.setPhoneNumber(orderRequest.getEmail());
        order.setEmail(orderRequest.getEmail());
        order.setAddress(orderRequest.getAddress());
        order.setComment(orderRequest.getComment());
        order.setCarrier(orderRequest.getCarrier());
        order.setPacking(orderRequest.getPacking());
        return order;
    }

    private void saveProductsForOrder(Order order, OrderRequest orderRequest) { //?????????????????
        productForOrderRepository.deleteAll(order.getProductsForOrder());
        List<ProductForOrder> productsForOrder = orderRequest.getProducts().stream()
                .map(p -> productForOrderRequestToProductForOrder(order, p)).collect(Collectors.toList());
        productForOrderRepository.saveAll(productsForOrder);
    }

    private ProductForOrder productForOrderRequestToProductForOrder(Order order, ProductForOrderRequest request) {
        return ProductForOrder.builder()
                .count(request.getCount())
                .order(order)
                .product(productService.findOne(request.getProductId()))
                .build();
    }
}
