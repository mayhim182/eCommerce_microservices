package com.mayank.orders.dto;

import jdk.jfr.Name;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderRequest {

  private List<OrderLineItemsdto> orderLineItemsdtoList;

}
