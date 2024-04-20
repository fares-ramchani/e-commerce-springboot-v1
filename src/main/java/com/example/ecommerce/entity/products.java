package com.example.ecommerce.entity;

import com.example.ecommerce.Enum.EnumProduit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class products {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nom;
    private Integer prix;
    private String discription;
    private Long quantite;
    @Enumerated(EnumType.STRING)
    private EnumProduit statut;
}
