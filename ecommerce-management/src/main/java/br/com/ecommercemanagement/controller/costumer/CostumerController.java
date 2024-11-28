package br.com.ecommercemanagement.controller.costumer;

import br.com.ecommercemanagement.service.costumer.CostumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ecommerce-management/v1/costumers")
@RequiredArgsConstructor
public class CostumerController {

    private final CostumerService costumerService;

    @PostMapping("create")
    public ResponseEntity<CostumerDTO> createCostumer(@RequestBody CostumerDTO costumerDTO){
        return new ResponseEntity<>(costumerService.createNewCostumer(costumerDTO),HttpStatus.CREATED);
    }

    @PostMapping("sign-in")
    public ResponseEntity<CostumerDTO> validateUser(@RequestBody CostumerDTO costumerDTO){
        return ResponseEntity.ok(costumerService.loginUser(costumerDTO.getEmail(), costumerDTO.getPass()));
    }

    @PostMapping("forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody CostumerDTO costumerDTO){
        costumerService.forgotPassword(costumerDTO.getEmail());
        return ResponseEntity.ok("Email de redefinição enviado com sucesso");
    }

    @PutMapping("{id}")
    public ResponseEntity<CostumerDTO> validateUser(@RequestBody CostumerDTO costumerDTO, @PathVariable("id") Long id){
        return ResponseEntity.ok(costumerService.updateCostumer(costumerDTO, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id){
        costumerService.deleteCostumer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
