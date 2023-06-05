package com.factoriaf5.pruebatecnica.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.factoriaf5.pruebatecnica.models.ItemGallery;
import com.factoriaf5.pruebatecnica.models.ImageGallery;
import com.factoriaf5.pruebatecnica.services.ItemGalleryService;

@RestController
@RequestMapping(path = "/api")

public class ItemGalleryController {

    private ItemGalleryService service;

    public ItemGalleryController(ItemGalleryService service){
        this.service = service;
     }

    @PostMapping(path = "/itemsgallery")
    public ItemGallery store(@RequestBody ItemGallery itemgallery) {
        return service.save(itemgallery);
    }

    @GetMapping("/itemsgallery")
    public List<ItemGallery> listAll() {
        return service.listAll();
    }

    @GetMapping("/itemsgallery/{id}")
    public ItemGallery listOne(@PathVariable Long id) {
        return service.listOne(id);
    }

    @DeleteMapping("/itemsgallery/{id}")
    public void delete(@PathVariable Long id) throws IOException {
        service.delete(id);
    }

    @PutMapping("/itemsgallery/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable Long id, @RequestBody ItemGallery aboutus) {
        try {
            ImageGallery imageActual = service.listOneImage(id);
            aboutus.setId(id);
            aboutus.setImageGallery(imageActual);
            ItemGallery aboutUsDB = service.save(aboutus);
            String idNew = aboutUsDB.getId() + "";

            Map<String, String> json = new HashMap<>();
            json.put("id", idNew);
            json.put("title", aboutUsDB.getTitle());
            json.put("message", "successful sign up");
            return ResponseEntity.status(HttpStatus.OK).body(json);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/itemsgallery/{id}/images")
    public ResponseEntity<Object> saveImageGallery(@RequestParam("image") MultipartFile multipartFile,
            @PathVariable Long id) throws IOException {
        return service.saveImageGallery(multipartFile, id);
    }

    @DeleteMapping("/itemsgallery/{id}/images")
    public void deleteImageGallery(@PathVariable Long id) throws IOException {
        service.deleteImageGallery(id);
    }
}