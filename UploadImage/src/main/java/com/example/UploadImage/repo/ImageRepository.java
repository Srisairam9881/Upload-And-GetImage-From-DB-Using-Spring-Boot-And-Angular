package com.example.UploadImage.repo;

import com.example.UploadImage.model.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ImageRepository extends JpaRepository<ImageEntity,Long> {
}
