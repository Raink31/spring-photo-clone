package org.karmelcafe.photoclone.web;

import org.karmelcafe.photoclone.model.Photo;
import org.karmelcafe.photoclone.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

// Initialise RestController
@RestController
public class PhotoController {

    // Connect to the PhotoService service file
    private final PhotoService photoService;
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    // Get all the photos
    @GetMapping("/photo")
    public Collection<Photo> get() {
        return photoService.get();
    }

    // Fetch a single photo with the id
    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = photoService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    // Delete a single photo with the id
    @DeleteMapping("/photo/{id}")
    public void delete(@PathVariable String id) {
        Photo photo = photoService.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    // Create a single photo with the id
    @PostMapping("/photo")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
