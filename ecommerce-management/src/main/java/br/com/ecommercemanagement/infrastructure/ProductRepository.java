package br.com.ecommercemanagement.infrastructure;

import br.com.ecommercemanagement.model.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductsEntity, Long> {
}
