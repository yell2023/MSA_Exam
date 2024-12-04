package com.sparta.msa_exam.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    //상품 추가 API
    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    // 상품 목록 조회 API
    @GetMapping
    public List<ProductResponseDto> getProducts() {
        return productService.getProductList();
    }

    @GetMapping("/{id}")
    public Map<String, Object> getProductId(@PathVariable Long productId) {
        Long id = productService.getProductId(productId);
        return Map.of("id", id);
    }
}
