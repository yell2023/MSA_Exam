package com.sparta.msa_exam.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
    private Long orderId;
    private List<Long> productIds;
    private LocalDateTime createdAt;

    public static OrderResponseDto from(OrderEntity order){
        return OrderResponseDto.builder()
                .orderId(order.getOrderId())
                .productIds(order.getProducts().stream()
                        .map(OrderProductEntity::getId)
                        .collect(Collectors.toList()))
                .build();
    }
}
