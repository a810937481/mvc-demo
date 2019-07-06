package com.aiyun.app.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class FileResource {

    @PostMapping("/file/upload")
    public ResponseEntity<String> upload(MultipartFile multipartFile) {
        System.out.println("file");
        return ResponseEntity.ok("upload success");
    }
}
