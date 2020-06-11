package com.example.progect.service.Impl;


import com.example.progect.domain.Picture;
import com.example.progect.mapper.PictureMapper;
import com.example.progect.service.PictureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Resource
    private PictureMapper pictureMapper;

    @Override
    public List<Picture> findAll() {
        List<Picture> Picture=pictureMapper.findAll();
        return Picture;
    }

    @Override
    public void addImages(Picture picture) {
        pictureMapper.addImages(picture);
    }

    @Override
    public void deletePicture(String img) {
        pictureMapper.deletePicture(img);
    }

    @Override
    public String findNameById(Integer id) {
        String img=pictureMapper.findNameById(id);
        return img;
    }
}
