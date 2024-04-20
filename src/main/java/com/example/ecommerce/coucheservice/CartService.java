package com.example.ecommerce.coucheservice;

import com.example.ecommerce.couchedto.CartRequestDto;
import com.example.ecommerce.entity.Cart;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface CartService {
    public void AddCart(CartRequestDto CartRequestDto);
    public List<Cart> GetCart(String client);
    public void DeleteCart(Long id);
}
