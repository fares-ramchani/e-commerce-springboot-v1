package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images_Produit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class imagesProduit {

    public imagesProduit(String name,String type,byte[] picbyte,String nameProduct){
        this.name=name;
        this.type=type;
        this.picbyte=picbyte;
        this.nameProduct=nameProduct;
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="type")
    private String type;
    @Column(name="picbyte",length = 100000)
    private byte[] picbyte;
    @Column(name="nameProduct")
    private String nameProduct;
}
