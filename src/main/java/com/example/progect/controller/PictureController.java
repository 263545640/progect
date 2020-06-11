package com.example.progect.controller;


import com.example.progect.commin.ResultBean;
import com.example.progect.commin.ResultBeanFactory;
import com.example.progect.domain.Picture;
import com.example.progect.service.PictureService;
import com.example.progect.utils.QiniuCloudUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/text")
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @ResponseBody
    @RequestMapping("/findAll")
    public List<Picture> findAll(){
        List<Picture> picture=pictureService.findAll();
//        ResultBeanFactory.success(picture);
        return picture;
    }

    @ResponseBody
    @RequestMapping(value="/addPicture", method= RequestMethod.POST)
    public ResultBean uploadImg(@RequestParam MultipartFile image, HttpServletRequest request) {
        ResultBean result = new ResultBean();
        if (image.isEmpty()) {
            result.setCode(400);
            result.setMsg("文件为空，请重新上传");
            return result;
        }
        try {
            byte[] bytes = image.getBytes();
            System.out.println(bytes);
            String imageName = UUID.randomUUID().toString();
            System.out.println(imageName);
            QiniuCloudUtil qiniuUtil = new QiniuCloudUtil();
            try {
                //使用base64方式上传到七牛云
                String url = qiniuUtil.put64image(bytes, imageName);
                System.out.println(url);
                result.setCode(200);
                result.setMsg("文件上传成功");
                result.setInfo(url);
                Picture picture = new Picture();
                picture.setPicture(imageName);
                pictureService.addImages(picture);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        } catch (IOException e) {
            result.setCode(500);
            result.setMsg("文件上传发生异常！");
            return result;
        }
    }

    @ResponseBody
    @RequestMapping(value="/delete", method= RequestMethod.POST)
    public ResultBean deleteImg(Integer id) {
        ResultBean result = new ResultBean();
        QiniuCloudUtil qiniuUtil = new QiniuCloudUtil();
        try {
            String img=pictureService.findNameById(id);
            qiniuUtil.delete(img);
            pictureService.deletePicture(img);
            result.setCode(200);
            result.setMsg("文件删除文件成功");
            return result;
        } catch (IOException e) {
            result.setCode(500);
            result.setMsg("删除文件发生异常！");
            return result;
        }
    }

}
