package com.example.progect.service;


import com.example.progect.domain.Picture;

import java.util.List;

public interface PictureService {

    List<Picture> findAll();

    void addImages(Picture picture);

    void deletePicture(String img);

    String findNameById(Integer id);
}
