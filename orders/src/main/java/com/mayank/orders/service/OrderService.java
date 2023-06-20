package com.mayank.orders.service;

import com.mayank.orders.dto.OrderLineItemsdto;
import com.mayank.orders.dto.OrderRequest;
import com.mayank.orders.model.Order;
import com.mayank.orders.model.OrderLineItems;
import com.mayank.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderService {

  private final OrderRepository orderRepository;

  public void placeOrder(OrderRequest orderRequest){
    Order order=new Order();
    order.setOrderNumber(UUID.randomUUID().toString());
    List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsdtoList()
      .stream()
      .map(this::mapToDto)
      .toList();

    order.setOrderLineItemsList(orderLineItems);

    orderRepository.save(order);

  }

  private OrderLineItems mapToDto(OrderLineItemsdto orderLineItemsdto) {
    OrderLineItems orderLineItems = new OrderLineItems();
    orderLineItems.setPrice(orderLineItemsdto.getPrice());
    orderLineItems.setQuantity(orderLineItemsdto.getQuantity());
    orderLineItems.setSkuCode(orderLineItemsdto.getSkuCode());
    return orderLineItems;
  }
}
