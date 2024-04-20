package com.example.ecommerce.coucheservice;

import com.example.ecommerce.Enum.EnumProduit;
import com.example.ecommerce.couchedao.productsRepository;
import com.example.ecommerce.couchedto.productsRequesteDto;
import com.example.ecommerce.entity.products;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class producteServiceImpl implements producteService {
    private productsRepository productsRepository;
    @Override
    public List<products> GetToutLesProducts() {
        return productsRepository.findAll();
    }
    @Override
    public void ajouter_un_produit(productsRequesteDto productsRequesteDto) {
        products products=new products();
        products.setDiscription(productsRequesteDto.getDiscription());
        products.setQuantite(productsRequesteDto.getQuantite());
        products.setStatut(EnumProduit.EnStock);
        products.setNom(productsRequesteDto.getNom());
        products.setPrix(productsRequesteDto.getPrix());
        productsRepository.save(products);
    }
    @Override
    public void DeleteProduct(Long id)
    {
        productsRepository.deleteById(id);
    }
    @Override
    public products getProduct(Long id)
    {
        return productsRepository.findById(id).get();
    }
    @Override
    public void ModifierProduit(Long id,Integer prix,Long quantite)
    {
        products products=productsRepository.findById(id).get();
        if(prix>0)
        {
            products.setPrix(prix);
        }
        if(quantite>0L)
        {
            products.setQuantite(quantite);
            products.setStatut(EnumProduit.EnStock);
        }
        productsRepository.save(products);
    }

}
