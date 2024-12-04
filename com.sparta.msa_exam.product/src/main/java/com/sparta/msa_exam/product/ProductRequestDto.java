package com.sparta.msa_exam.product;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {
    private String name;
    private Integer supplyPrice;
    private LocalDateTime createdAt;

    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .name(this.name)
                .supplyPrice(this.supplyPrice)
                .createdAt(this.createdAt)
                .build();
    }
}
