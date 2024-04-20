package com.example.ecommerce.coucheWeb;

import com.example.ecommerce.couchedao.ImageProduitRepository;
import com.example.ecommerce.couchedao.productsRepository;
import com.example.ecommerce.entity.imagesProduit;
import com.example.ecommerce.entity.products;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/image")
@AllArgsConstructor
@NoArgsConstructor
public class imageProduitController {
    @Autowired
    private ImageProduitRepository ImageProduitRepository;
    @Autowired
    private productsRepository productsRepository;
    @PostMapping(path = "/AddImageProduit")
    public ResponseEntity.BodyBuilder AddImageProduit(@RequestParam("imageFile") MultipartFile File)throws IOException
    {
        products products =productsRepository.findAll().get(productsRepository.findAll().size()-1);
        imagesProduit img=new imagesProduit(File.getOriginalFilename(),File.getContentType(), compressBytes(File.getBytes()),products.getNom());
        ImageProduitRepository.save(img);
        return ResponseEntity.status(HttpStatus.OK);
    }
    @GetMapping(path = "/GetImgProduit")
    public List<imagesProduit> GetImgProduit()throws IOException
    {
        List<imagesProduit> imagesProduit1= ImageProduitRepository.findAll();
        List<imagesProduit> imagesProduit2=new ArrayList<>();
        for(int i=0;i<imagesProduit1.size();i++)
        {
            imagesProduit2.add(new imagesProduit(imagesProduit1.get(i).getName(),imagesProduit1.get(i).getType(),decompressBytes(imagesProduit1.get(i).getPicbyte()),imagesProduit1.get(i).getNameProduct()));
        }
        return imagesProduit2;
    }
    @GetMapping(path = "/GetimgProduct")
    public imagesProduit GetOneImg(@RequestParam String nameProduct)throws IOException
    {
        imagesProduit imagesProduit =ImageProduitRepository.findByNameProduct(nameProduct);
        imagesProduit img=new imagesProduit(imagesProduit.getName(),imagesProduit.getType(),decompressBytes(imagesProduit.getPicbyte()),imagesProduit.getNameProduct());
        return img;
    }
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}
