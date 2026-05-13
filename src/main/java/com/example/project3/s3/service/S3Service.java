package com.example.project3.s3.service;

import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final S3Presigner s3Presigner;

    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucket;

    /**
     * 업로드용 Pre-signed URL 생성
     * @param fileName 저장할 파일명
     * @return 생성된 URL 문자열
     */
    public String getPreSignedUrlForUpload(String fileName) {
        // 1. 어떤 객체를 업로드할지 정의
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucket)
                .key(fileName)
                .contentType("image/jpeg") // 파일 타입에 맞게 설정 가능
                .build();

        // 2. Pre-signed 요청 설정 (유효 시간 10분)
        PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(10))
                .putObjectRequest(putObjectRequest)
                .build();

        // 3. URL 생성 및 반환
        return s3Presigner.presignPutObject(presignRequest).url().toString();
    }
}