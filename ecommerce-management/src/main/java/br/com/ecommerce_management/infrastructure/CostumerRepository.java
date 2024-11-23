package br.com.ecommerce_management.infrastructure;

import br.com.ecommerce_management.model.CostumersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends JpaRepository<CostumersEntity, Long> {
}
