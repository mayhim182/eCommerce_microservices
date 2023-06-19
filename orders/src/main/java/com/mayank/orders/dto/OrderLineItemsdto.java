package com.mayank.orders.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderLineItemsdto {
  private String skuCode;
  private BigDecimal price;
  private Integer quantity;
}
