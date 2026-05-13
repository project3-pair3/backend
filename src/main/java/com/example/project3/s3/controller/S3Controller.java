package com.example.project3.s3.controller;

import com.example.project3.s3.service.S3Service;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/s3")
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;

    @Operation(summary = "S3 presignedUrl 반환", description = "파일 이름을 요청하면 S3에서 받은 presignedUrl을 반환합니다.")
    @GetMapping("/presigned-url")
    public String getPresignedUrl(@RequestParam String fileName) {
        return s3Service.getPreSignedUrlForUpload(fileName);
    }
}
