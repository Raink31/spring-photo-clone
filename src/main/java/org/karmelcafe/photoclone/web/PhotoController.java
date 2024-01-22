package org.karmelcafe.photoclone.web;

import org.karmelcafe.photoclone.model.Photo;
import org.karmelcafe.photoclone.service.PhotoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

// Initialise RestController
@RestController
public class PhotoController {

    // Landing page
    @GetMapping("/")
    public String hello() {
        return "Hello world";
    }

    // Connect to the PhotoService service file
    private final PhotoService photoService;
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    // Get all the photos
    @GetMapping("/photo")
    public Iterable<Photo> get() {
        return photoService.get();
    }

    // Fetch a single photo with the id
    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable Integer id) {
        Photo photo = photoService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    // Delete a single photo with the id
    @DeleteMapping("/photo/{id}")
    public void delete(@PathVariable Integer id) {
        photoService.remove(id);
    }

    // Create a single photo with the id
    @PostMapping("/photo")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
