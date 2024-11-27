package br.com.ecommercemanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_ITEMS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsEntity {

    @Column(name = "ID_ORDER_ITEM")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "orderItemsSequence")
    @SequenceGenerator(name = "orderItemsSequence", sequenceName = "orderItemsSeq", allocationSize = 1)
    @Id
    private Long idOrderCostumer;

    private Long quantity;

    private Long price;

    private Long total;

    @ManyToOne
    private OrderCostumerEntity orderCostumer;

    @ManyToOne
    private ProductsEntity productsEntity;

}
