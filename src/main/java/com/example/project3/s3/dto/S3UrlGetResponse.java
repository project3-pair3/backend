package com.example.project3.s3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class S3UrlGetResponse {
    String presignedUrl;
    String imageUrl;
}
