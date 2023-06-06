package com.factoriaf5.pruebatecnica.utils;

public class RouteFileUploadImage {
    private static String pathImagesGallery = "src/main/resources/static/images/gallery-images/";

    public static String pathToSaveImage(String typeOfImage) {
        if (typeOfImage == "imagesGallery") {
            return pathImagesGallery;
        }
        return null;
    }
}
