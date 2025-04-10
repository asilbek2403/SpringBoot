package com.example.metrosPj2.service;


import com.example.metrosPj2.entity.FileStorage;
import com.example.metrosPj2.entity.FileStorageStatus;
import com.example.metrosPj2.repository.FileStorageRepository;
import jakarta.transaction.Transactional;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service

public class FileStorageService {

    private final FileStorageRepository filestorageRepository;

    @Value("${server.upload.folder")
    private String uploadFolder;

    private final Hashids hashids;

    public FileStorageService(FileStorageRepository filestorageRepository) {
        this.filestorageRepository = filestorageRepository;
        hashids = new Hashids(getClass().getName(),5);
    }


 
    public void saveW(MultipartFile multipartFile) {
        FileStorage fileStorage = new FileStorage();
        fileStorage.setName(multipartFile.getOriginalFilename());
        fileStorage.setExtension(getExt(multipartFile.getOriginalFilename()));
        fileStorage.setFileSize(multipartFile.getSize());
        fileStorage.setContentType(multipartFile.getContentType());
        fileStorage.setFileStatus(FileStorageStatus.DRIFT);

        filestorageRepository.save(fileStorage);

        Date now = new Date();
        File uploadFolder = new File(String.format("%s/upload_files/%d/%d/%d", this.uploadFolder,
                1900+now.getYear(),
                1+now.getMonth(),
                now.getDate()));
        if(!uploadFolder.exists() && uploadFolder.mkdirs()){
            System.out.println(" Yuklash uchun Dow for Papka creat");
        }

        fileStorage.setHashId(hashids.encode(fileStorage.getId()));
        fileStorage.setPath(String.format("upload_files/%d/%d/%d/%s.%s",
                1900+now.getYear(),
                1+now.getMonth(),
                now.getDate(), fileStorage.getHashId(),
                fileStorage.getExtension() )  );

        filestorageRepository.save(fileStorage);

        uploadFolder = uploadFolder.getAbsoluteFile();
        File file = new File(uploadFolder,String.format("%s.%s",fileStorage.getHashId(),fileStorage.getExtension()));
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Transactional(readOnly = true)
    public FileStorage findByHashId(String hashId){
        return filestorageRepository.findByHashId(hashId);
    }

    public String getExt(String fileName){
        String ext=null;
        if(fileName != null && !fileName.isEmpty()){
            int l = fileName.lastIndexOf(".");
            if(l > 0 && l<= fileName.length() -2){
                ext = fileName.substring(l+1);
            }
        } return ext;
    }


}
