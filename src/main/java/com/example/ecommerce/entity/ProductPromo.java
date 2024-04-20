package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Product_promo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPromo {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nom;
    private Integer prix;
    private String discription;
}
