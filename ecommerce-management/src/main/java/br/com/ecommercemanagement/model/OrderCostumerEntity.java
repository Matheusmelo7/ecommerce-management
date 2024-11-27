package br.com.ecommercemanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ORDER_COSTUMER")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCostumerEntity {

    @Column(name = "ID_ORDER_COSTUMER")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "orderCostumerSequence")
    @SequenceGenerator(name = "orderCostumerSequence", sequenceName = "orderCostumersSeq", allocationSize = 1)
    @Id
    private Long idOrderCostumer;

    @Column(name = "ORDER_DATE")
    @CreationTimestamp
    private LocalDateTime orderDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "TOTAL")
    private String total;

    @Column(name = "DELIVERY_ADDRESS")
    private String deliveryAddress;

    @OneToMany
    private List<OrderItemsEntity> orderItemsEntity;

    @OneToOne
    private PaymentsEntity paymentsEntity;

    @ManyToOne
    private CostumersEntity costumersEntity;

}
