package com.api.product.service;

import com.api.product.exception.NotFoundException;
import com.api.product.model.ProductModel;
import com.api.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public ProductModel findById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    public ProductModel save(ProductModel product) {
        return productRepository.save(product);
    }

    public ProductModel update(Integer id, ProductModel productDetails) {
        ProductModel existingProduct = this.findById(id);

        existingProduct.setName(productDetails.getName());
        existingProduct.setSalePrice(productDetails.getSalePrice());

        return productRepository.save(existingProduct);
    }

    public void delete(Integer id) {
        ProductModel product = this.findById(id);
        productRepository.delete(product);
    }
}
