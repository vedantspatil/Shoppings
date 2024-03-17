package com.distributedsystems.orderservice.dto;

import com.distributedsystems.orderservice.model.OrderLineItems;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
