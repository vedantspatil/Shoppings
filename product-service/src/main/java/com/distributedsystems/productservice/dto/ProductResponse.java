package com.distributedsystems.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    //separate your dto from model to hide entities related to business to outside world
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
