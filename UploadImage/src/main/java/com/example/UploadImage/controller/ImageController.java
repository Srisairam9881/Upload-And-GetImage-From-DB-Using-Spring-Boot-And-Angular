package com.example.UploadImage.controller;

import com.example.UploadImage.model.ImageEntity;
import com.example.UploadImage.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

// Controller class
@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("data") MultipartFile data) {
        try {
            // Extract file name from the key
            String fileName = data.getOriginalFilename();
System.out.println(fileName);
            // Further processing...

            imageService.saveImage(data);
            return ResponseEntity.ok().body("Image uploaded successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image.");
        }
    }

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Optional<ImageEntity> imageEntityOptional = imageService.getImageById(id);
        if (imageEntityOptional.isPresent()) {
            ImageEntity imageEntity = imageEntityOptional.get();
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Set appropriate content type
                    .body(imageEntity.getData());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}