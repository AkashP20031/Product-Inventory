package com.productInventory.service;

import com.productInventory.dto.Productdto;
import com.productInventory.entity.Product;
import com.productInventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImp implements ProductService{

    @Autowired
    ProductRepository productRepository;

    public Product addProducts(Productdto productDto)
    {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setBrand(productDto.getBrand());
        product.setSupplier(productDto.getSupplier());
        product.setCategory(productDto.getCategory());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByCategories(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
    }

    @Override
    public Product updateProduct(int id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Product not found with ID: " + id));
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setUpdated_at(LocalDateTime.now());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(int id) {
        if (!productRepository.existsById(id)) {
            throw new NoSuchElementException("Product not found with ID: " + id);
        }
        productRepository.deleteById(id);
    }
}
