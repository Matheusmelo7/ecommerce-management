package br.com.ecommercemanagement.controller.payment;

import br.com.ecommercemanagement.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ecommerce-management/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("create")
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO){
        return ResponseEntity.ok(paymentService.createNewPayment(paymentDTO));
    }

}
