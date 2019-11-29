package com.codegym.freshfood.repository;

import com.codegym.freshfood.model.Picture;
import com.codegym.freshfood.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture,Long> {
  List<Picture> findAllByProductId(Long product_id);
  List<Picture> findAllByProduct_Category_Id(Long product_category_id);
}
