package com.sparta.msa_exam.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    // 주문 추가 API
    @PostMapping
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto requestDto) {
        return orderService.createOrder(requestDto);
    }

    // 주문 추가 API - 상품 API 호출 실패 케이스
//    @PostMapping
//    public OrderResponseDto createOrder(@RequestBody OrderRequestDto requestDto) {
//        return orderService.createOrder(requestDto);
//    }

    // 주문에 상품을 추가하는 API
//    @PutMapping("/{orderId}")
//    public OrderResponseDto updateOrder(@PathVariable("orderId") Long orderId, @RequestBody ProductRequestDto requestDto) {
//        return orderService.updateOrder(orderId, requestDto);
//    }

    // 주문 단건 조회 API
    @GetMapping("/{orderId}")
    public OrderResponseDto getOrder(@PathVariable("orderId") Long orderId) {
        return orderService.getOrder(orderId);
    }

}
