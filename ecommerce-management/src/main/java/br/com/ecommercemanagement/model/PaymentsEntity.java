package br.com.ecommercemanagement.model;

import br.com.ecommercemanagement.controller.payment.PaymentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENTS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentsEntity {

    @Column(name = "ID_PAYMENTS")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "paymentsSequence")
    @SequenceGenerator(name = "paymentsSequence", sequenceName = "paymentsSeq", allocationSize = 1)
    @Id
    private Long idPayments;

    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;

    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "PAYMENT_DATE")
    private LocalDateTime paymentDate;

    @Column(name = "PAYMENT_TOKEN")
    private String paymentToken;

    @OneToOne
    private OrderCostumerEntity orderCostumerEntity;

    public PaymentDTO toDTO() {
        return PaymentDTO.builder()
                .idPayment(this.idPayments)
                .paymentMethod(this.paymentMethod)
                .paymentStatus(this.paymentStatus)
                .amount(this.amount)
                .build();
    }
}
