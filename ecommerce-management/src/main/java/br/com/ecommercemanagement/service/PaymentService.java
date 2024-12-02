package br.com.ecommercemanagement.service;

import br.com.ecommercemanagement.controller.payment.PaymentDTO;
import br.com.ecommercemanagement.infrastructure.OrderRepository;
import br.com.ecommercemanagement.infrastructure.PaymentRepository;
import br.com.ecommercemanagement.model.PaymentsEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentDTO createNewPayment(PaymentDTO paymentDTO) {

        var orderEntity = orderRepository.findById(paymentDTO.getIdOrder())
                .orElseThrow();

        var entity = PaymentsEntity
                .builder()
                .paymentStatus("pending")
                .paymentMethod(paymentDTO.getPaymentMethod())
                .amount(paymentDTO.getAmount())
                .orderCostumerEntity(orderEntity)
                .build();

        return paymentRepository.save(entity).toDTO();

    }
}
