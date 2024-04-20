package com.example.ecommerce.coucheservice;

import com.example.ecommerce.couchedao.ClientRepository;
import com.example.ecommerce.couchedto.ClientRequestDto;
import com.example.ecommerce.entity.Client;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@AllArgsConstructor
@Transactional
@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository ClientRepository;
    private JdbcUserDetailsManager JdbcUserDetailsManager;
    private PasswordEncoder PasswordEncoder;

    @Override
    public void ajouterClient(ClientRequestDto ClientRequestDto) {
        Client client=new Client();
        client.setNom(ClientRequestDto.getNom());
        client.setPrenom(ClientRequestDto.getPrenom());
        client.setAdresse(ClientRequestDto.getAdresse());
        client.setMail(ClientRequestDto.getMail());
        client.setTel(ClientRequestDto.getTel());
        JdbcUserDetailsManager.createUser(User.withUsername(ClientRequestDto.getNom()).password(PasswordEncoder.encode(ClientRequestDto.getMdp())).authorities("CLIENT").build());
        ClientRepository.save(client);
    }
}
