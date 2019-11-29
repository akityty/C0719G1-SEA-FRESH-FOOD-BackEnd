package com.codegym.freshfood.service;

import com.codegym.freshfood.model.Picture;

import java.util.List;
import java.util.Optional;

public interface PictureService {
    void save(Picture picture);
    List<Picture> findAll();
    List<Picture> findAllByProductId(Long product_id);
    Optional<Picture> findById(Long id);
    List<Picture> findAllByProduct_Category_Id(Long product_category_id);
}
