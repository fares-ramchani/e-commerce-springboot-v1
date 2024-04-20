package com.example.ecommerce.coucheservice;

import com.example.ecommerce.couchedao.CartRepository;
import com.example.ecommerce.couchedto.CartRequestDto;
import com.example.ecommerce.entity.Cart;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
@Transactional
public class CartServiceImpl implements CartService {
    private CartRepository CartRepository;
    @Override

    public void AddCart(CartRequestDto CartRequestDto) {
        Cart cart =new Cart();
        cart.setPrix(CartRequestDto.getPrix());
        cart.setNameProduct(CartRequestDto.getNameProduct());
        cart.setQuantite(CartRequestDto.getQuantite());
        cart.setClient(CartRequestDto.getClient());
        CartRepository.save(cart);
    }

    @Override
    public List<Cart> GetCart(String client) {
        return CartRepository.findByClient(client);
    }

    @Override
    public void DeleteCart(Long id) {
        CartRepository.deleteById(id);
    }
}
