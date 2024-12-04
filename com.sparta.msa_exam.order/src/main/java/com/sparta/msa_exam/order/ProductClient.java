package com.sparta.msa_exam.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/products/{id}")
    Map<String, Object> getProductById(@PathVariable Long productId);
}
