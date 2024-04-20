package com.example.ecommerce.couchedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientRequestDto {
    private String nom;
    private String prenom;
    private String adresse;
    private String tel;
    private String mail;
    private String mdp;
}
