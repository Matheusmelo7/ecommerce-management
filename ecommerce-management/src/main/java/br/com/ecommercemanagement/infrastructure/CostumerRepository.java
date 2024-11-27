package br.com.ecommercemanagement.infrastructure;

import br.com.ecommercemanagement.model.CostumersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CostumerRepository extends JpaRepository<CostumersEntity, Long> {

    Optional<CostumersEntity> findByEmail(String email);

}
