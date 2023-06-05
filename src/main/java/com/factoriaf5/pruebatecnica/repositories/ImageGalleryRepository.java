package com.factoriaf5.pruebatecnica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factoriaf5.pruebatecnica.models.ImageGallery;

public interface ImageGalleryRepository extends JpaRepository <ImageGallery, Long> {
    public ImageGallery findByImage(String image);
}
