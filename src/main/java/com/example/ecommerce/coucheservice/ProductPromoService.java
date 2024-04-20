package com.example.ecommerce.coucheservice;

import com.example.ecommerce.couchedto.ProductPromoRequestDto;
import com.example.ecommerce.couchedto.productsRequesteDto;
import com.example.ecommerce.entity.ProductPromo;
import com.example.ecommerce.entity.products;

import java.util.List;

public interface ProductPromoService {
    public void ajouter_un_produitPromo(ProductPromoRequestDto ProductPromoRequestDto);
    List<ProductPromo> GetToutLesProductsPromo();
    public void DeleteProductPromo(Long id);
}
