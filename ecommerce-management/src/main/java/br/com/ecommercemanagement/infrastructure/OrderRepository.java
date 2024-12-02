package br.com.ecommercemanagement.infrastructure;

import br.com.ecommercemanagement.model.OrderCostumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository <OrderCostumerEntity, Long> {

    List<OrderCostumerEntity> findAllOrderCostumerByCostumersEntityIdCostumer(Long id);

}
