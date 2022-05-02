package com.example.backendeksamen3semester.controller;
// Klasse fra https://www.techgeeknext.com/spring-boot/spring-boot-upload-image
public class ImageUploadResponse {
    private String message;

    public ImageUploadResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
