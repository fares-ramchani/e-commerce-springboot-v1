package com.example.ecommerce.couchedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class productsRequesteDto {
    private Long id;
    private String nom;
    private Integer prix;
    private String discription;
    private Long quantite;
}
