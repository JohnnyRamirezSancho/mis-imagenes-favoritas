package com.factoriaf5.pruebatecnica.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itemgallery")
public class ItemGallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_itemgallery")
    private Long id;

    @Column(nullable = false)
    private String title;
    
    @OneToOne
    private ImageGallery imagegallery;

    public ItemGallery() {
    }

    public ItemGallery(Long id, String title, ImageGallery imageGallery) {
        this.id = id;
        this.title = title;
        this.imagegallery = imageGallery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImageGallery getImageGallery() {
        return imagegallery;
    }

    public void setImageGallery(ImageGallery imagegallery) {
        this.imagegallery = imagegallery;
    }   
}