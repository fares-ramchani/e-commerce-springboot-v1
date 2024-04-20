package com.example.ecommerce.couchedao;

import com.example.ecommerce.Enum.EnumDemande;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande,Long> {

}
