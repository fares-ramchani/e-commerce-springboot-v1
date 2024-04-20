package com.example.ecommerce.coucheservice;

import com.example.ecommerce.Enum.EnumDemande;
import com.example.ecommerce.Enum.EnumProduit;
import com.example.ecommerce.couchedao.ClientRepository;
import com.example.ecommerce.couchedao.DemandeDetailsRepository;
import com.example.ecommerce.couchedao.DemandeRepository;
import com.example.ecommerce.couchedao.productsRepository;
import com.example.ecommerce.couchedto.DemandeRequestDto;
import com.example.ecommerce.entity.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
import java.util.List;
@AllArgsConstructor
@Transactional
@Service
public class DemandeServiceImpl implements DemandeService {
    private DemandeRepository DemandeRepository;
    private DemandeDetailsRepository DemandeDetailsRepository;
    private productsRepository productsRepository;
    private ClientRepository ClientRepository;
    private SendMailMessage SendMailMessage;
    @Override

    public void AddDemande( List<Cart> Cart) {
        Demande Demande=new Demande();
        Long somme=0L;
        for(int i=0;i<Cart.size();i++)
        {
            somme=somme+Cart.get(i).getPrix()*Cart.get(i).getQuantite();
        }
        Demande.setPrixTotal(somme);
        Demande.setStatue(EnumDemande.EnCoursDeTraitement);
        Demande.setClient(Cart.get(0).getClient());
        DemandeRepository.save(Demande);
        for(int i=0;i<Cart.size();i++)
        {
            DemandeDetails DemandeDetails=new DemandeDetails();
            DemandeDetails.setDemande(Demande);
            DemandeDetails.setPrix(Cart.get(i).getPrix());
            DemandeDetails.setNameProduct(Cart.get(i).getNameProduct());
            DemandeDetails.setQuantite(Cart.get(i).getQuantite());
            DemandeDetailsRepository.save(DemandeDetails);
        }

    }
    @Override
    public List<Demande> GetDemande() {
        return DemandeRepository.findAll();
    }
    @Override
    public void accepterDemande(Long id) throws MessagingException, jakarta.mail.MessagingException {

        Demande Demande = DemandeRepository.findById(id).get();
        List<DemandeDetails> DemandeDetails= DemandeDetailsRepository.findByDemande_Id(id);
        for(int i=0;i<DemandeDetails.size();i++)
        {
            products products=productsRepository.findByNom(DemandeDetails.get(i).getNameProduct());
            products.setQuantite(products.getQuantite()-DemandeDetails.get(i).getQuantite());
            if(products.getQuantite()<=0)
            {
                products.setStatut(EnumProduit.HorsStock);
            }
            productsRepository.save(products);
        }
        Demande.setStatue(EnumDemande.Aceepter);
        DemandeRepository.save(Demande);
        Client Client=ClientRepository.findByNom(Demande.getClient());
        SendMailMessage.sendMailToClient(Client.getMail(),"Bonjour"+" "+Client.getNom()+" "+Client.getPrenom()+"\n"+"Merci d'avoir effectué vos achats sur e-commerce !","Confirmation de commande");
    }
    @Override
    public void RefusDemande(Long id)
    {
        Demande Demande =DemandeRepository.findById(id).get();
        Demande.setStatue(EnumDemande.Refuser);
        DemandeRepository.save(Demande);
    }
}
