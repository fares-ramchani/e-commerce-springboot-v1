package com.example.ecommerce.couchedao;

import com.example.ecommerce.entity.imagesProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageProduitRepository extends JpaRepository<imagesProduit,Long>{
    imagesProduit findByNameProduct(String nameProduct);
}
