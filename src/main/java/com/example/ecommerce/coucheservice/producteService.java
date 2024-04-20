package com.example.ecommerce.coucheservice;

import com.example.ecommerce.couchedto.productsRequesteDto;
import com.example.ecommerce.entity.products;

import java.util.List;

public interface producteService {
    public void ajouter_un_produit(productsRequesteDto productsRequesteDto);
    List<products> GetToutLesProducts();
    public void DeleteProduct(Long id);
    public products getProduct(Long id);
    public void ModifierProduit(Long id,Integer prix,Long quantite);
}
