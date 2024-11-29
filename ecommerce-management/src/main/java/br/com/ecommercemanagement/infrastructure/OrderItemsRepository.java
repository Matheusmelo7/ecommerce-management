package br.com.ecommercemanagement.infrastructure;

import br.com.ecommercemanagement.model.OrderItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity, Long> {

  //  List<OrderItemsEntity> findAllByIdsIn(List<Long> ids);

}
