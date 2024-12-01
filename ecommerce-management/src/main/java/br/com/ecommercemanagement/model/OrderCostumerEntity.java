package br.com.ecommercemanagement.model;

import br.com.ecommercemanagement.controller.order.OrderDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.query.Order;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ORDER_COSTUMER")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderItemsEntity> orderItemsEntity;

    @OneToOne
    private PaymentsEntity paymentsEntity;

    @ManyToOne
    private CostumersEntity costumersEntity;

    public OrderDTO toDTO() {
        return OrderDTO.builder()
                .idOrder(this.idOrderCostumer)
                .orderItemsEntity(this.orderItemsEntity)
                .deliveryAddress(this.deliveryAddress)
                .valueTotal(this.total)
                .status(this.status)
                .build();
    }
}
