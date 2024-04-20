package com.example.ecommerce.couchedto;

import com.example.ecommerce.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeRequestDto {
    private List<Cart> ListeP;
}
