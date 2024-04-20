package com.example.ecommerce.coucheWeb;

import com.example.ecommerce.couchedto.CartRequestDto;
import com.example.ecommerce.coucheservice.CartService;
import com.example.ecommerce.entity.Cart;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "Cart")
@AllArgsConstructor
@CrossOrigin("*")
public class CartController {
    private CartService CartService;
    @PostMapping(path = "/AddCart")
    public void AddCart(@RequestBody CartRequestDto CartRequestDto)
    {
        CartService.AddCart(CartRequestDto);
    }
    @GetMapping(path="GetCart")
    public List<Cart>  GetCart(@RequestParam String client)
    {
        System.out.println(client);
        return CartService.GetCart(client);
    }
    @DeleteMapping(path="DeleteCart")
    public void DeleteCart(@RequestParam Long id)
    {
        CartService.DeleteCart(id);
    }
}
