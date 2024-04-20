package com.example.ecommerce.coucheservice;

import com.example.ecommerce.couchedao.DemandeDetailsRepository;
import com.example.ecommerce.entity.DemandeDetails;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
@Transactional
public class DemandeDetailsServiceImpl implements DemandeDetailsService {
    private DemandeDetailsRepository DemandeDetailsRepository;
    @Override
    public List<DemandeDetails> GetDemandeDetails() {
        return DemandeDetailsRepository.findAll();
    }
}
