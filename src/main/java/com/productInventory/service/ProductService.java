package com.productInventory.service;

import com.productInventory.dto.Productdto;
import com.productInventory.entity.Product;

import java.util.List;

public interface ProductService {
    Product addProducts(Productdto product) ;

    List<Product> getProduct();

    List<Product> getProductByCategories(String category);

    Product getProductById(int id);

    Product updateProduct(int id, Product updatedProduct);

    void deleteProduct(int id);
}
