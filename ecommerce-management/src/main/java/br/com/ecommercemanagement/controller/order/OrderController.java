package br.com.ecommercemanagement.controller.order;

import br.com.ecommercemanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ecommerce-management/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("create")
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(orderService.createOrder(orderDTO));
    }

    @PostMapping("items/create")
    public ResponseEntity<OrderDTO> createOrderItem(@RequestBody OrderItemDTO orderItemDTO){
        return ResponseEntity.ok(orderService.createOrderItem(orderItemDTO));
    }

    @GetMapping("costumer/{id}")
    public ResponseEntity<List<OrderDTO>> findOrdersByIdClient(@PathVariable("id") Long id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }



}
