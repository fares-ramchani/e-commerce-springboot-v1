package com.example.ecommerce.coucheservice;

import com.example.ecommerce.couchedao.ProductPromoReposotory;
import com.example.ecommerce.couchedto.ProductPromoRequestDto;
import com.example.ecommerce.entity.ProductPromo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@AllArgsConstructor
@Service
@Transactional
public class ProductPromoServiceImpl implements ProductPromoService {
    private ProductPromoReposotory ProductPromoReposotory;
    @Override
    public void ajouter_un_produitPromo(ProductPromoRequestDto ProductPromoRequestDto) {
        ProductPromo ProductPromo=new ProductPromo();
        ProductPromo.setDiscription(ProductPromoRequestDto.getDiscription());
        ProductPromo.setNom(ProductPromoRequestDto.getNom());
        ProductPromo.setPrix(ProductPromoRequestDto.getPrix());
        ProductPromoReposotory.save(ProductPromo);
    }

    @Override
    public List<ProductPromo> GetToutLesProductsPromo() {
        return null;
    }

    @Override
    public void DeleteProductPromo(Long id) {

    }
}
