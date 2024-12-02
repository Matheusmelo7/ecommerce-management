package br.com.ecommercemanagement.infrastructure;

import br.com.ecommercemanagement.model.PaymentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentsEntity, Long> {
}
