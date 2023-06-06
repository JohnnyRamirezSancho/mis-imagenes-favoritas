package com.factoriaf5.pruebatecnica.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imagegallery")
public class ImageGallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagegallery")
    private Long id;
    @Column(nullable = false)
    private String image;

    public ImageGallery(Long id, String image) {
        this.id = id;
        this.image = image;
    }

    public ImageGallery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String name) {
        this.image = name;
    }
}