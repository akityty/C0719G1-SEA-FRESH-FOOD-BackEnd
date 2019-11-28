package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.Picture;
import com.codegym.freshfood.repository.PictureRepository;
import com.codegym.freshfood.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public void save(Picture picture) {
        pictureRepository.save(picture);
    }

    @Override
    public List<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public List<Picture> findAllByProductId(Long product_id) {
        return pictureRepository.findAllByProductId(product_id);
    }

    @Override
    public Optional<Picture> findById(Long id) {
        return pictureRepository.findById(id);
    }

    @Override
    public List<Picture> findAllByProduct_Category_Id(Long product_category_id) {
        return pictureRepository.findAllByProduct_Category_Id(product_category_id);
    }
}
