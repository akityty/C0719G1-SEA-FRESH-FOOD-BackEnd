package com.codegym.freshfood.service.impl;

import com.codegym.freshfood.model.Picture;
import com.codegym.freshfood.repository.PictureRepository;
import com.codegym.freshfood.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;

public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    @Override
    public void save(Picture picture) {
        pictureRepository.save(picture);
    }
}
