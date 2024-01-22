package org.karmelcafe.photoclone.repository;

import org.karmelcafe.photoclone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
