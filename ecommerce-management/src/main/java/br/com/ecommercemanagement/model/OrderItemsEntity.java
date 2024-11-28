package br.com.ecommercemanagement.model;

import br.com.ecommercemanagement.controller.order.OrderItemDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_ITEMS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemsEntity {

    @Column(name = "ID_ORDER_ITEM")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "orderItemsSequence")
    @SequenceGenerator(name = "orderItemsSequence", sequenceName = "orderItemsSeq", allocationSize = 1)
    @Id
    private Long idOrderCostumer;

    private Long quantity;

    private Long price;

    private Long total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private OrderCostumerEntity orderCostumer;

    @ManyToOne(fetch = FetchType.EAGER)
    private ProductsEntity productsEntity;

    public OrderItemDTO toDTO() {
        return OrderItemDTO
                .builder()
                .idOrderCostumer(this.idOrderCostumer)
                .total(this.total)
                .price(this.price)
                .quantity(this.quantity)
                .build();
    }
}
