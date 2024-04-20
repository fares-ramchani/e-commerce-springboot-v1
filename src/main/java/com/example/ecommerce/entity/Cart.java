package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nameProduct;
    private Long prix;
    private Long quantite;
    private String client;
}
