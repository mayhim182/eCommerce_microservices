package com.mayank.orders.service;

import com.mayank.orders.dto.OrderLineItemsdto;
import com.mayank.orders.dto.OrderRequest;
import com.mayank.orders.model.Order;
import com.mayank.orders.model.OrderLineItems;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

  public void placeOrder(OrderRequest orderRequest){
    Order order=new Order();
    order.setOrderNumber(UUID.randomUUID().toString());
    orderRequest.getOrderLineItemsdtoList()
      .stream()
      .map(orderLineItemsdto -> mapToDto(orderLineItemsdto))

  }

  private OrderLineItems mapToDto(OrderLineItemsdto orderLineItemsdto) {
    OrderLineItems
  }
}
