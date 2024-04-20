package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeDetails {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nameProduct;
    private Long prix;
    private Long quantite;
    @ManyToOne
    @JoinColumn(name = "request_id")
    private Demande demande;
}
