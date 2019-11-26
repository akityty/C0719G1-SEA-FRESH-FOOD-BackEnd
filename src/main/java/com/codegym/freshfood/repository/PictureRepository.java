package com.codegym.freshfood.repository;

import com.codegym.freshfood.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture,Long> {
}
