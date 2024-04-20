package com.example.ecommerce.couchedao;

import com.example.ecommerce.entity.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface productsRepository extends JpaRepository<products,Long> {
    @Query("select p from products p where p.nom = ?1")
    products findByNom(String nom);
}
