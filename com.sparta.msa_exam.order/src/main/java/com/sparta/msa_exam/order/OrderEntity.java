package com.sparta.msa_exam.order;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @OneToMany(mappedBy = "order")
    private List<OrderProductEntity> products = new ArrayList<>();

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public void addOrderProduct(OrderProductEntity orderProduct){
        this.products.add(orderProduct);
    }
}
