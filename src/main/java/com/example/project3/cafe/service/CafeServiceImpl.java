package com.example.project3.cafe.service;

import com.example.project3.cafe.domain.Cafe;
import com.example.project3.cafe.dto.CafeRequest;
import com.example.project3.cafe.dto.CafeResponse;
import com.example.project3.cafe.repository.CafeRepository;
import org.springframework.stereotype.Service;


@Service
public class CafeServiceImpl implements CafeService {
    CafeRepository cafeRepository;

    CafeServiceImpl(CafeRepository cafeRepository){
        this.cafeRepository = cafeRepository;
    }

    public CafeResponse createCafe(CafeRequest cafeRequest) {
        Cafe requestCafe = Cafe.builder()
                .cafeName(cafeRequest.getCafeName())
                .addressCity(cafeRequest.getAddressCity())
                .addressDistrict(cafeRequest.getAddressDistrict())
                .addressDetail(cafeRequest.getAddressDetail())
                .open(cafeRequest.getOpen())
                .close(cafeRequest.getClose())
                .imageUrl(cafeRequest.getImageUrl())
                .build();

        Cafe newCafe = cafeRepository.save(requestCafe);
        return CafeResponse.from(newCafe);
    }
}
