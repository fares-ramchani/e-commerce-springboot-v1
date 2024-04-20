package com.example.ecommerce.coucheWeb;

import com.example.ecommerce.couchedto.DemandeRequestDto;
import com.example.ecommerce.coucheservice.DemandeService;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Demande;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping(path = "Demande")
@AllArgsConstructor
@CrossOrigin("*")
public class DemandeController {
    private DemandeService DemandeService;
    @PostMapping(path="AddDemande")
    public void AddDemande(@RequestBody List<Cart> Cart)
    {
        DemandeService.AddDemande(Cart);
    }
    @GetMapping(path="/GetDemande")
    public List<Demande> GetDemande() {
        return DemandeService.GetDemande();
    }
    @PutMapping(path="/AcceptDemande")
    public void accepterDemande(@RequestParam ("id") Long id) throws MessagingException, jakarta.mail.MessagingException {
        DemandeService.accepterDemande(id);
    }
    @PutMapping(path="/RefusDemande")
    public void refusDemande(@RequestParam ("id") Long id)
    {
        DemandeService.RefusDemande(id);
    }
}
