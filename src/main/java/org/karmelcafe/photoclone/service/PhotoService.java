package org.karmelcafe.photoclone.service;
import org.karmelcafe.photoclone.model.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// @Component
@Service
public class PhotoService {

    // Create the database
    private final Map<String, Photo> db = new HashMap<>() {{
        put("1", new Photo("1", "hello.jpg"));
    }};

    // Get all the photos
    public Collection<Photo> get() {
        return db.values();
    }

    // Fetch a single photo with the id
    public Photo get(String id) {
        return db.get(id);
    }

    // Delete a single photo with the id
    public Photo remove(String id) {
        return db.remove(id);
    }

    // Create a single photo with the id
    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }
}
