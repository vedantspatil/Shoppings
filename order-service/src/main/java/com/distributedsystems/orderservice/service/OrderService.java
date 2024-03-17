package com.distributedsystems.orderservice.service;

import com.distributedsystems.orderservice.dto.OrderLineItemsDto;
import com.distributedsystems.orderservice.dto.OrderRequest;
import com.distributedsystems.orderservice.dto.OrderResponse;
import com.distributedsystems.orderservice.model.Order;
import com.distributedsystems.orderservice.model.OrderLineItems;
import com.distributedsystems.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtosList()
                                                        .stream()
                                                        .map(this::mapToDto)
                                                        .toList();
        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);
        log.info("Order is placed");
    }
    public List<OrderResponse> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        List<OrderResponse> orderResponses = orders.stream().map(order -> maptoResponse(order)).toList();
        return orderResponses;
    }

    private OrderResponse maptoResponse(Order order) {
        return OrderResponse.builder()
                .orderNumber(order.getOrderNumber())
                .orderLineItemsDtoList(order.getOrderLineItemsList().stream().map(orderLineItems -> mapFromOrderToDto(orderLineItems)).toList())
                .build();
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        return OrderLineItems.builder()
                .skuCode(orderLineItemsDto.getSkuCode())
                .quantity(orderLineItemsDto.getQuantity())
                .price(orderLineItemsDto.getPrice()).build();
    }

    private OrderLineItemsDto mapFromOrderToDto(OrderLineItems orderLineItems) {
        return OrderLineItemsDto.builder()
                .skuCode(orderLineItems.getSkuCode())
                .quantity(orderLineItems.getQuantity())
                .price(orderLineItems.getPrice())
                .build();
    }
}
