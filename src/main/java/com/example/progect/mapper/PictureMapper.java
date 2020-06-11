package com.example.progect.mapper;

import com.example.progect.domain.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PictureMapper {

    List<Picture> findAll();

    void addImages(Picture picture);

    String findNameById(Integer id);

    void deletePicture(String img);
}
