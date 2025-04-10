package com.example.metrosPj2.ichidabir;



import com.example.metrosPj2.entity.FileStorage;
import com.example.metrosPj2.service.FileStorageService;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/api")


public class FileStorageResource {

    private final FileStorageService fileStorageService;

    public FileStorageResource(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity uploadW(@RequestParam("file")MultipartFile multipartFile){
        fileStorageService.saveW(multipartFile);
        return ResponseEntity.ok(multipartFile.getOriginalFilename() + " uploaded successfully FILE saqlnadi !!!");

    }




    @GetMapping("/perview/{hashId}")
    public ResponseEntity getPerview(@PathVariable String hashId) throws IOException {


        FileStorage fileStorage = fileStorageService.findByHashId(hashId);
        return ResponseEntity.ok()
                .header(
                HttpHeaders.CONTENT_DISPOSITION,
                        "inline;  fileName=\"" + URLEncoder.encode(fileStorage.getName())
                ).contentType(MediaType.parseMediaType(fileStorage.getContentType())
                ).contentLength(fileStorage.getFileSize()
                ).body(new FileUrlResource(String.format("%s/%s", uploadFolder, fileStorage.getName())));

    }

}
