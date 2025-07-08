package com.productInventory.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productdto {

        private String name;
        private String description;
        private double price;
        private int stock;
        private String brand;
        private String supplier;
        private String category;
}

