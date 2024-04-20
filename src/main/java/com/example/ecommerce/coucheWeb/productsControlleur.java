package com.example.ecommerce.coucheWeb;

import com.example.ecommerce.couchedto.productsRequesteDto;
import com.example.ecommerce.coucheservice.producteService;
import com.example.ecommerce.entity.products;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "products")
@AllArgsConstructor
@CrossOrigin("*")
public class productsControlleur {
    private producteService producteService;
    @GetMapping(path="/GetAllProducts")
    public List<products> GetAllProducts()
    {
        return producteService.GetToutLesProducts();
    }
    @PostMapping(path = "/ajouterUnProduit")
    public void ajouter_un_produit(@RequestBody productsRequesteDto productsRequesteDto){
        producteService.ajouter_un_produit(productsRequesteDto);
    }
    @DeleteMapping(path="DeleteProduct")
    public void DeleteProduct(@RequestParam Long id)
    {
        producteService.DeleteProduct(id);
    }
    @GetMapping(path = "/GetProduct")
    public products getProduct(@RequestParam Long id)
    {
        return producteService.getProduct(id);
    }
    @PutMapping(path="/ModifierProduit")
    public void ModifierProduit(@RequestParam ("id") Long id ,@RequestParam ("prix") Integer prix,@RequestParam ("quantite") Long quantite)
    {
        System.out.println(id);
        producteService.ModifierProduit(id,prix,quantite);

    }
}
