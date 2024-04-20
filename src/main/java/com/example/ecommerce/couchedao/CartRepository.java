package com.example.ecommerce.couchedao;

import com.example.ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    @Query("select c from Cart c where c.client = ?1")
    List<Cart> findByClient(String client);

}
