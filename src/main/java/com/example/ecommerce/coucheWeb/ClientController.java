package com.example.ecommerce.coucheWeb;

import com.example.ecommerce.couchedto.ClientRequestDto;
import com.example.ecommerce.coucheservice.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "Client")
@AllArgsConstructor
@CrossOrigin("*")
public class ClientController {
    private ClientService ClientService;
    @PostMapping(path = "AddClient")
    public void ajouterClient(@RequestBody ClientRequestDto ClientRequestDto)
    {
        System.out.println(ClientRequestDto);
        ClientService.ajouterClient(ClientRequestDto);
    }
}
