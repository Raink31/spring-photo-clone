package org.karmelcafe.photoclone.service;
import org.karmelcafe.photoclone.model.Photo;
import org.karmelcafe.photoclone.repository.PhotoRepository;
import org.springframework.stereotype.Service;

// @Component
@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    // Get all the photos
    public Iterable<Photo> get() {
        return photoRepository.findAll();
    }

    // Fetch a single photo with the id
    public Photo get(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    // Delete a single photo with the id
    public void remove(Integer id) {
        photoRepository.deleteById(id);
    }

    // Create a single photo with the id
    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photoRepository.save(photo);
        return photo;
    }
}
