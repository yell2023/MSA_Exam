package com.sparta.msa_exam.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        ProductEntity product = requestDto.toEntity();
        return ProductResponseDto.from(productRepository.save(product));
    }

    public List<ProductResponseDto> getProductList() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponseDto::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public Long getProductId(Long productId) {
        return productRepository.findById(productId)
                .map(product -> product.getProductId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "존재하지 않는 상품입니다."
                ));
    }
}
