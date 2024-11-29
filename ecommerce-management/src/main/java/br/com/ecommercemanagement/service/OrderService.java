package br.com.ecommercemanagement.service;

import br.com.ecommercemanagement.controller.order.OrderDTO;
import br.com.ecommercemanagement.controller.order.OrderItemDTO;
import br.com.ecommercemanagement.exception.BusinessException;
import br.com.ecommercemanagement.infrastructure.CostumerRepository;
import br.com.ecommercemanagement.infrastructure.OrderItemsRepository;
import br.com.ecommercemanagement.infrastructure.OrderRepository;
import br.com.ecommercemanagement.infrastructure.ProductRepository;
import br.com.ecommercemanagement.model.OrderCostumerEntity;
import br.com.ecommercemanagement.model.OrderItemsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CostumerRepository costumerRepository;
    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemsRepository;
    private final ProductRepository productRepository;


    public OrderDTO createOrder(OrderDTO orderDTO) {

        var costumer = costumerRepository.findById(orderDTO.getIdCostumer()).orElseThrow(()
                -> new BusinessException("Costumer not found", HttpStatus.BAD_REQUEST));

        var orderEntity = OrderCostumerEntity
                .builder()
                .costumersEntity(costumer)
                .status("pending")
                .build();

        return orderRepository.save(orderEntity).toDTO();
    }


    public OrderDTO createOrderItem(OrderItemDTO orderItemDTO) {

        var product = productRepository.findById(orderItemDTO.getIdProduct()).orElseThrow(()
                -> new BusinessException("Product not found", HttpStatus.BAD_REQUEST));


        var order = orderRepository.findById(orderItemDTO.getIdOrder()).orElseThrow(()
                -> new BusinessException("Order not found", HttpStatus.BAD_REQUEST));

        var entity = OrderItemsEntity.builder()
                .orderCostumer(order)
                .quantity(orderItemDTO.getQuantity())
                .price(product.getPrice() * orderItemDTO.getQuantity())
                .total(product.getPrice() * orderItemDTO.getQuantity())
                .productsEntity(product)
                .build();

        order.getOrderItemsEntity().addAll(Arrays.asList(entity));

        return orderRepository.save(order).toDTO();

    }

    public List<OrderDTO> getOrderById(Long id) {
        return orderRepository.findAllOrderCostumerByCostumersEntityIdCostumer(id)
                .stream()
                .map(OrderCostumerEntity::toDTO).toList();
    }
}
