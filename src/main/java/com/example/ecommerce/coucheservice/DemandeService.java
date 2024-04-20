package com.example.ecommerce.coucheservice;

import com.example.ecommerce.couchedto.DemandeRequestDto;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Demande;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;


public interface DemandeService {
    public void AddDemande(List<Cart> Cart);
    public List<Demande> GetDemande();
    public void accepterDemande(Long id) throws MessagingException, jakarta.mail.MessagingException;
    public void RefusDemande(Long id);
}
