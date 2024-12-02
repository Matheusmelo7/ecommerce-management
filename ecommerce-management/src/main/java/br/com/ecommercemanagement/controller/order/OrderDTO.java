package br.com.ecommercemanagement.controller.order;


import br.com.ecommercemanagement.model.OrderItemsEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {

    private Long idOrder;
    private Long idCostumer;
    private List<Long> itemsIdsList;
    private String deliveryAddress;
    private String valueTotal;
    private Long idPayment;
    private String status;
    private List<OrderItemsEntity> orderItemsEntity;




}
