package com.amazon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String asin; // 亚马逊标准识别号
    
    private String title;
    
    private String description;
    
    private Double price;
    
    private String category;
    
    private String brand;
    
    private Integer stockQuantity;
    
    private String imageUrl;
    
    private Double rating;
    
    private Integer reviewCount;
    
    private String keywords; // 逗号分隔的关键词列表
    
    private Boolean active = true;
}