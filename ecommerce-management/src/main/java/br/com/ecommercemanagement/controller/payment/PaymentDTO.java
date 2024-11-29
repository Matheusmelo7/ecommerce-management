package br.com.ecommercemanagement.controller.payment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDTO {

    private Long idPayment;
    private String paymentMethod;
    private String paymentStatus;
    private Long amount;
    private String paymentToken;
    private Long idOrder;

}
