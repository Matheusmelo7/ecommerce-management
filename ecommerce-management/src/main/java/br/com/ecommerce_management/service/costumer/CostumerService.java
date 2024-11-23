package br.com.ecommerce_management.service.costumer;

import br.com.ecommerce_management.controller.costumer.CostumerDTO;
import br.com.ecommerce_management.infrastructure.CostumerRepository;
import br.com.ecommerce_management.model.CostumersEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostumerService {

    private final CostumerRepository costumerRepository;


    public CostumerDTO createNewCostumer(CostumerDTO costumerDTO) {

        var entity = CostumersEntity
                .builder()
                .email(costumerDTO.getEmail())
                .pass(costumerDTO.getPass())
                .phone(costumerDTO.getPhone())
                .name(costumerDTO.getName())
                .build();

        return costumerRepository.save(entity).toDTO();
    }

}
