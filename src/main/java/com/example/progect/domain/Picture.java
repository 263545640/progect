package com.example.progect.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Picture {

    private Integer id;

    private String picture;

    private String pictureFormat;

    private String createTime;

    private String modificationTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPictureFormat() {
        return pictureFormat;
    }

    public void setPictureFormat(String pictureFormat) {
        this.pictureFormat = pictureFormat;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(String modificationTime) {
        this.modificationTime = modificationTime;
    }

    @Override
    public String toString() {
        return "picture{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", pictureFormat='" + pictureFormat + '\'' +
                ", createTime=" + createTime +
                ", modificationTime=" + modificationTime +
                '}';
    }
}
