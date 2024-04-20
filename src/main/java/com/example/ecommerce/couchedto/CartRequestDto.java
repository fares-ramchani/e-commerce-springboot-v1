package com.example.ecommerce.couchedto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDto {
    private String nameProduct;
    private Long prix;
    private Long quantite;
    private String client;
}
