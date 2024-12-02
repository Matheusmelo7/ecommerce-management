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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

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

    public void finalizeOrder(OrderDTO orderDTO, Long id) {
        var order = orderRepository.findById(id).orElseThrow();

        order.setDeliveryAddress(orderDTO.getDeliveryAddress());
        order.setStatus("payment_pending");

        var total = order
                .getOrderItemsEntity()
                .stream()
                .flatMapToLong(orderItemsEntity -> LongStream.of(orderItemsEntity.getQuantity()
                        * orderItemsEntity.getProductsEntity().getPrice()))
                .sum();
        order.setTotal(String.valueOf(total));
        orderRepository.save(order);

    }

    public void completePaymentOrder(Long id) {

        var order = orderRepository.findById(id).orElseThrow();
        order.setStatus("delivery_pending");

        orderRepository.save(order);

    }


    public List<OrderDTO> getOneOrderById(Long id) {
        return orderRepository.findById(id)
                .stream()
                .map(OrderCostumerEntity::toDTO).toList();
    }

    public List<OrderDTO> getOrderById(Long id) {
        return orderRepository.findAllOrderCostumerByCostumersEntityIdCostumer(id)
                .stream()
                .map(OrderCostumerEntity::toDTO).toList();
    }

    @Transactional
    public void deleteOrderItem(Long idOrderItem) {

        orderItemsRepository.deleteItemOrder(idOrderItem);

    }
}
