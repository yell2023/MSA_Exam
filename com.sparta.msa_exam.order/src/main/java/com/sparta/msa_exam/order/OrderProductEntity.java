package com.sparta.msa_exam.order;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "products")
public class OrderProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @Column(nullable = false)
    private Long productId;

    public static OrderProductEntity toEntity(Long productId, OrderEntity order) {
        return OrderProductEntity.builder()
                .productId(productId)
                .order(order)
                .build();
    }

}
