package br.com.ecommercemanagement.infrastructure;

import br.com.ecommercemanagement.model.OrderItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity, Long> {

    @Modifying
    @Query(value = "DELETE FROM ORDER_COSTUMER_ORDER_ITEMS_ENTITY WHERE ORDER_ITEMS_ENTITY_ID_ORDER_ITEM = :id", nativeQuery = true)
    void deleteItemOrder(@Param("id") Long id);


}
