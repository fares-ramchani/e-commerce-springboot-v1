package com.example.ecommerce.couchedao;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
    Client findByNom(String nom);
}
