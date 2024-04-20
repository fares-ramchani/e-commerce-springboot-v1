package com.example.ecommerce.coucheservice;

import com.example.ecommerce.couchedto.ClientRequestDto;
import org.springframework.web.bind.annotation.PostMapping;

public interface ClientService{
    public void ajouterClient(ClientRequestDto ClientRequestDto);
}
