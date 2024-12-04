package com.sparta.msa_exam.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    private Long productId;
    private String name;
    private Integer supplyPrice;
    private LocalDateTime createdAt;

    public static ProductResponseDto from(ProductEntity product) {
        return ProductResponseDto.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .supplyPrice(product.getSupplyPrice())
                .createdAt(product.getCreatedAt())
                .build();
    }
}
