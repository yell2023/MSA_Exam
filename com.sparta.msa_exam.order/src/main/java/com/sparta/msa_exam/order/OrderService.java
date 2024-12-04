package com.sparta.msa_exam.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductClient productClient;
    private final OrderRepository orderRepository;

    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto requestDto) {

        OrderEntity order = requestDto.toEntity();

        for (Long productId : requestDto.getProductIds()) {
            OrderProductEntity orderProduct = OrderProductEntity.toEntity(productId, order);
            order.addOrderProduct(orderProduct);
        }

        orderRepository.save(order);
        return OrderResponseDto.from(order);
    }

    @Transactional(readOnly = true)
    public OrderResponseDto getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .map(OrderResponseDto::from)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 주문을 찾을 수 없습니다."));
    }

}
