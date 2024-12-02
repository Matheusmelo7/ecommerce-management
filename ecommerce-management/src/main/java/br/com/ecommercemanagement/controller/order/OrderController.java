package br.com.ecommercemanagement.controller.order;

import br.com.ecommercemanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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


    @DeleteMapping("items/{id}/delete")
    public ResponseEntity<OrderDTO> deleteOrderItem(@PathVariable("id") Long id){
        orderService.deleteOrderItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("costumer/{id}")
    public ResponseEntity<List<OrderDTO>> findOrdersByIdClient(@PathVariable("id") Long id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @GetMapping("order/{id}")
    public ResponseEntity<List<OrderDTO>> findOrderById(@PathVariable("id") Long id){
        return ResponseEntity.ok(orderService.getOneOrderById(id));
    }

    @PostMapping("{id}/finalize")
    public ResponseEntity finalizeOrderClient(@PathVariable("id") Long idOrder,
                                              @RequestBody OrderDTO orderDTO){
        orderService.finalizeOrder(orderDTO, idOrder);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}/complete-payment")
    public ResponseEntity completePaymentOrderClient(@PathVariable("id") Long idOrder){
        orderService.completePaymentOrder(idOrder);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }






}
