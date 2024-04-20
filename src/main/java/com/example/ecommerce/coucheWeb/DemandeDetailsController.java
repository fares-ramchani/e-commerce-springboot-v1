package com.example.ecommerce.coucheWeb;

import com.example.ecommerce.coucheservice.DemandeDetailsService;
import com.example.ecommerce.coucheservice.DemandeService;
import com.example.ecommerce.entity.DemandeDetails;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "DemandeDetails")
@AllArgsConstructor
@CrossOrigin("*")
public class DemandeDetailsController {
    private DemandeDetailsService DemandeDetailsService;
    @GetMapping(path="GetDemandeDetails")
    public List<DemandeDetails> GetDemandeDetails()
    {
        return DemandeDetailsService.GetDemandeDetails();
    }
}
