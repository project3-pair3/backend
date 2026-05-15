package com.example.project3.s3.service;

import com.example.project3.s3.dto.S3UrlGetResponse;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.time.Duration;
import java.util.Set;
import java.util.UUID;

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
    public S3UrlGetResponse getPreSignedUrlForUpload(String fileName, String contentType) {
        // jpg, jpeg, png, webp로 한정
        // 1. fileName 확장자 확인
        if (fileName == null || !fileName.contains(".")) {
            throw new IllegalArgumentException("확장자가 없습니다.");
        }

        String extension =
                fileName.substring(fileName.lastIndexOf('.') + 1)
                        .toLowerCase();

        final Set<String> ALLOWED_EXTENSIONS = Set.of("jpg", "jpeg", "png", "webp");

        if (!ALLOWED_EXTENSIONS.contains(extension)) {
            throw new IllegalArgumentException("지원하지 않는 확장자입니다.");
        }

        // 2. MIME type 확인
        final Set<String> ALLOWED_CONTENT_TYPES = Set.of(
                        "image/jpeg",
                        "image/png",
                        "image/webp"
        );

        if (contentType == null || !ALLOWED_CONTENT_TYPES.contains(contentType.toLowerCase())) {
            throw new IllegalArgumentException("지원하지 않는 Content-Type 입니다.");
        }

        // 3. #1, #2 서로 동일한지 체크
        boolean isValid = switch (extension) {
            case "jpg", "jpeg" ->
                    contentType.equals("image/jpeg");
            case "png" ->
                    contentType.equals("image/png");
            case "webp" ->
                    contentType.equals("image/webp");
            default -> false;
        };

        if (!isValid) {
            throw new IllegalArgumentException("확장자와 Content-Type이 일치하지 않습니다.");
        }

        // 4. "temp/" + UUID 붙이기
        String key = "temp/" + UUID.randomUUID() + "-" + fileName;

        // 5. presignedURL 반환
        // 1) 어떤 객체를 업로드할지 정의
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .contentType(contentType) // 파일 타입에 맞게 설정 가능
                .build();

        // 2) Pre-signed 요청 설정 (유효 시간 10분)
        PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(10))
                .putObjectRequest(putObjectRequest)
                .build();

        // 6. imageUrl 만들기
        String presignedUrl = s3Presigner.presignPutObject(presignRequest).url().toString();

        String objectUrl = presignedUrl.split("\\?")[0];

        // 7. URL 생성 및 반환
        return new S3UrlGetResponse(presignedUrl, objectUrl);
    }
}