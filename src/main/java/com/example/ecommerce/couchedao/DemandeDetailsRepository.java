package com.example.ecommerce.couchedao;

import com.example.ecommerce.entity.Demande;
import com.example.ecommerce.entity.DemandeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DemandeDetailsRepository extends JpaRepository<DemandeDetails,Long> {
    @Query("select d from DemandeDetails d where d.demande.id = ?1")
    List<DemandeDetails> findByDemande_Id(Long id);
}
