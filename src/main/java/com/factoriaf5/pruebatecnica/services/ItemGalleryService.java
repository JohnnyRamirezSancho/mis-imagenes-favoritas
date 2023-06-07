package com.factoriaf5.pruebatecnica.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.factoriaf5.pruebatecnica.models.ItemGallery;
import com.factoriaf5.pruebatecnica.models.ImageGallery;
import com.factoriaf5.pruebatecnica.repositories.ItemGalleryRepository;
import com.factoriaf5.pruebatecnica.repositories.ImageGalleryRepository;
import com.factoriaf5.pruebatecnica.utils.FileUploadUtil;
import com.factoriaf5.pruebatecnica.utils.RouteFileUploadImage;

@Service
public class ItemGalleryService {
    private ItemGalleryRepository repository;

    @Autowired
    private ImageGalleryRepository imageGalleryRepository;

    public ItemGalleryService(ItemGalleryRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Object> saveImageGallery(MultipartFile multipartFile, Long id) throws IOException {
        ImageGallery imageExist = listOneImage(id);
        if (imageExist != null) {
            deleteImageGallery(id);
        }

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        ImageGallery fileNameExist = imageGalleryRepository.findByImage(fileName);

        if (fileNameExist != null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        String uploadDir = RouteFileUploadImage.pathToSaveImage("imagesGallery");
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        ImageGallery imageGalleryNew = new ImageGallery();
        imageGalleryNew.setImage(fileName);
        imageGalleryRepository.save(imageGalleryNew);

        ItemGallery itemGalleryToAddImage = repository.findById(id).orElseThrow();
        itemGalleryToAddImage.setImageGallery(imageGalleryNew);
        repository.save(itemGalleryToAddImage);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    public ItemGallery save(ItemGallery itemGalleryNew) {
        return repository.save(itemGalleryNew);
    }

    public List<ItemGallery> listAll() {
        return repository.findAll();
    }

    public ItemGallery listOne(Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    public void delete(Long id) throws IOException {
        ImageGallery imageExist = listOneImage(id);
        if (imageExist != null) {
            deleteImageGallery(id);
        }
        repository.deleteById(id);
    }

    public ItemGallery update(Long id, ItemGallery itemGalleryNew) {
        ItemGallery itemGalleryToUpdate = itemGalleryNew;
        itemGalleryToUpdate.setId(id);
        return repository.save(itemGalleryToUpdate);
    }

    public void deleteImageGallery(Long idaboutus) throws IOException {
        ItemGallery itemGalleryToDeleteImage = repository.findById(idaboutus).orElseThrow(null);
        ImageGallery imageToDelete = itemGalleryToDeleteImage.getImageGallery();
        itemGalleryToDeleteImage.setImageGallery(null);
        imageGalleryRepository.delete(imageToDelete);
        Path fileToDeletePath = Paths.get("src/main/resources/static/" + imageToDelete.getImage());
        Files.delete(fileToDeletePath);
    }

    public ImageGallery listOneImage(Long id) {
        ItemGallery itemGalleryImage = repository.findById(id).orElseThrow(null);
        ImageGallery imageGallery = itemGalleryImage.getImageGallery();
        if (imageGallery == null) {
            return null;
        }
        Long idImage = imageGallery.getId();
        return imageGalleryRepository.findById(idImage).orElseThrow(null);
    }
}
