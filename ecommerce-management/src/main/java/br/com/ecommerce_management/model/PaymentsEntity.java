package br.com.ecommerce_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENTS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsEntity {

    @Column(name = "ID_PAYMENTS")
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
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

}
