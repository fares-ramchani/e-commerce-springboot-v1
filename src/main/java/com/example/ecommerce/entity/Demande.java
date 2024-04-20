package com.example.ecommerce.entity;

import com.example.ecommerce.Enum.EnumDemande;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Demande {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;
    private Long PrixTotal;
    @Enumerated(EnumType.STRING)
    private EnumDemande Statue;
    private String client;
    @Transient
    @OneToMany(mappedBy = "demande",fetch = FetchType.LAZY)
    private List<DemandeDetails> DemandeDetails;
}