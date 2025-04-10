package com.example.metrosPj2.entity;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
public class FileStorage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String extension;
    private String contentType;
    private Long fileSize;
    private String path;
    private String hashId;

    //Statusini int emas STRING maqul

    @Enumerated(EnumType.STRING)
    private FileStorageStatus fileStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public FileStorageStatus getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(FileStorageStatus fileStatus) {
        this.fileStatus = fileStatus;
    }



}
