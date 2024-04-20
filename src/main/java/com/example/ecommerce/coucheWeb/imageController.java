package com.example.ecommerce.coucheWeb;

import com.example.ecommerce.couchedao.ImageProduitRepository;
import com.example.ecommerce.couchedao.ProductPromoReposotory;
import com.example.ecommerce.couchedao.imagePromoRepository;
import com.example.ecommerce.entity.ProductPromo;
import com.example.ecommerce.entity.imagesProduit;
import com.example.ecommerce.entity.imagesPromo;
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
@RequestMapping(path = "/imagePromo")
@AllArgsConstructor
@NoArgsConstructor
public class imageController {
    @Autowired
    private imagePromoRepository imagePromoRepository;
    private ProductPromoReposotory ProductPromoReposotory;
    private ImageProduitRepository ImageProduitRepository;
    @PostMapping(path = "/AddImagePromo")
    public ResponseEntity.BodyBuilder AddImagePromo(@RequestParam("imageFile")MultipartFile File)throws IOException
    {
        imagesPromo img=new imagesPromo(File.getOriginalFilename(),File.getContentType(), compressBytes(File.getBytes()));
        imagePromoRepository.save(img);
        return ResponseEntity.status(HttpStatus.OK);
    }
    @GetMapping(path = "/GetImgPromo")
    public List<imagesPromo> GetImgPromo()throws IOException
    {
        List<imagesPromo> imgPromo1= imagePromoRepository.findAll();
        List<imagesPromo> imgPromo2=new ArrayList<>();
        for(int i=0;i<imgPromo1.size();i++)
        {
            imgPromo2.add(new imagesPromo(imgPromo1.get(i).getName(),imgPromo1.get(i).getType(),decompressBytes(imgPromo1.get(i).getPicbyte())));
        }
        return imgPromo2;
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
