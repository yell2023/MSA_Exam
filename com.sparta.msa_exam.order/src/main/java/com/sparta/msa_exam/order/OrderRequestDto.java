package com.sparta.msa_exam.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
    private List<Long> productIds;
    private LocalDateTime createdAt;

    public OrderEntity toEntity() {
        return OrderEntity.builder()
                .createdAt(this.createdAt)
                .build();
    }
}
