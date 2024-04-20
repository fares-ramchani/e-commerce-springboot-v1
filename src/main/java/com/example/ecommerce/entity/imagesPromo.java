package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images_promo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class imagesPromo {
    public imagesPromo(String name,String type,byte[] picbyte){
        this.name=name;
        this.type=type;
        this.picbyte=picbyte;
    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
