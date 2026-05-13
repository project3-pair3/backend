package com.example.project3.cafe.service;

import com.example.project3.cafe.dto.*;

import java.util.List;

public interface CafeService {
    public CafeResponse createCafe(CafeRequest cafeRequest);
    public List<CafeResponse> getCafeList();
    public CafeMenuResponse createDailyMenu(CafeMenuRequest menuRequest);
    public CafeMenuResponse getDailyMenu(Long cafeId);

    public CafeInfoResponse getCafeInfo(Long userId);
}
