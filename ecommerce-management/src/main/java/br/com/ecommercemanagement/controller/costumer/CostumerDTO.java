package br.com.ecommercemanagement.controller.costumer;

import br.com.ecommercemanagement.model.OrderCostumerEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CostumerDTO {

    private Long id;
    private String name;
    private String email;
    private String pass;
    private LocalDateTime createAt;
    private String phone;
    @Setter
    private String accessToken;
    private List<OrderCostumerEntity> orderCostumerEntities;
}
