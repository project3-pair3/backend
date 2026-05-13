package com.example.project3.s3.controller;

import com.example.project3.s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/s3")
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;

    @GetMapping("/presigned-url")
    public String getPresignedUrl(@RequestParam String fileName) {
        return s3Service.getPreSignedUrlForUpload(fileName);
    }
}
