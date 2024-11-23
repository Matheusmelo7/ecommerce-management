package br.com.ecommerce_management.controller.costumer;

import br.com.ecommerce_management.service.costumer.CostumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ecommerce-management/v1/costumer")
@RequiredArgsConstructor
public class CostumerController {

    private final CostumerService costumerService;

    @PostMapping
    public ResponseEntity<CostumerDTO> createCostumer(@RequestBody CostumerDTO costumerDTO){
        return ResponseEntity.ok(costumerService.createNewCostumer(costumerDTO));
    }

}
