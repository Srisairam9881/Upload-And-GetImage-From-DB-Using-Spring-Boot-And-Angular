package com.example.UploadImage.service;

import com.example.UploadImage.model.ImageEntity;
import com.example.UploadImage.repo.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public void saveImage(MultipartFile file) throws IOException {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setData(file.getBytes()); // Convert file to byte array
        imageRepository.save(imageEntity);
    }
    public Optional<ImageEntity> getImageById(Long id) {
        return imageRepository.findById(id);
    }
    public List<ImageEntity> getAllImages() {
        return imageRepository.findAll();
    }
}