package com.myshop.demo.controller;


import com.myshop.demo.dto.ProductMyPriceRequestDto;
import com.myshop.demo.dto.ProductRequestDto;
import com.myshop.demo.dto.ProductResponseDto;
import com.myshop.demo.entity.ApiUseTime;
import com.myshop.demo.entity.User;
import com.myshop.demo.repository.ApiUseTimeRepository;
import com.myshop.demo.security.UserDetailsImpl;
import com.myshop.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    private final ApiUseTimeRepository apiUseTimeRepository;

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return productService.createProduct(requestDto, userDetails.getUser());
    }
    @PutMapping("/products/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id , @RequestBody ProductMyPriceRequestDto productMyPriceRequestDto){
        return  productService.updateProduct(id,productMyPriceRequestDto);
    }

    @GetMapping("/products")
    public Page<ProductResponseDto> getProduct(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") boolean isAsc,

            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return productService.getProduct(userDetails.getUser(), page - 1, size, sortBy, isAsc);
    }

    @PostMapping("/products/{productId}/folder")
    public void addFolder(
            @PathVariable Long productId,
            @RequestParam Long folderId,
            @AuthenticationPrincipal UserDetailsImpl userDetails){

        productService.addFolders(productId, folderId , userDetails.getUser());

    }

    @GetMapping("/folders/{folderId}/products")
    public Page<ProductResponseDto> getProductsInFolder(
            @PathVariable Long folderId,
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam("sortBy") String sortBy,
            @RequestParam("isAsc") boolean isAsc,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
           return productService.getProductsInFolder(folderId, page - 1, size, sortBy, isAsc,userDetails.getUser());

    }
}
