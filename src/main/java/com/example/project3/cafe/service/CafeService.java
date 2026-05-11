package com.example.project3.cafe.service;

import com.example.project3.cafe.dto.CafeRequest;
import com.example.project3.cafe.dto.CafeResponse;

public interface CafeService {
    public CafeResponse createCafe(CafeRequest cafeRequest);
}
