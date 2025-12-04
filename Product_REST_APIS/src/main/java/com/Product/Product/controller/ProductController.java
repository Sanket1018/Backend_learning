package com.Product.Product.controller;

import com.Product.Product.dto.ProductDTO;
import com.Product.Product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    // create a product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO)
    {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }

    // get All products
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    // get a products by id
    @GetMapping("/{id}")
    public ProductDTO getProductsById(@PathVariable Long id){
        return productService.getProductById(id);
    }


    // update the product by id
    @PutMapping("{/id}")
    public ProductDTO updateProductById(@PathVariable Long id,@RequestBody ProductDTO productDTO){
        productService.updateProductById(id,productDTO);
    }

    // delete the product by id

}
