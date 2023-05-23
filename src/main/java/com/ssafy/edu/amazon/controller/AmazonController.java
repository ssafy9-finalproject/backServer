package com.ssafy.edu.amazon.controller;

import java.net.URL;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.edu.amazon.service.AmazonService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
public class AmazonController {

    private final AmazonService awsS3Service;

    @PostMapping("/uploadImage")
    public ResponseEntity<URL> uploadFile(MultipartFile image){
         return ResponseEntity.ok(awsS3Service.uploadFile(image));
    }
}

