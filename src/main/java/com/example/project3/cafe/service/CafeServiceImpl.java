package com.example.project3.cafe.service;

import com.example.project3.cafe.domain.Cafe;
import com.example.project3.cafe.dto.*;
import com.example.project3.cafe.repository.CafeRepository;
import com.example.project3.menu.domain.Menu;
import com.example.project3.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class CafeServiceImpl implements CafeService {
    CafeRepository cafeRepository;
    MenuRepository menuRepository;

    CafeServiceImpl(CafeRepository cafeRepository, MenuRepository menuRepository){
        this.cafeRepository = cafeRepository;
        this.menuRepository = menuRepository;
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

    // 카페 리스트 조회 (필터링 무관!)
    public List<CafeResponse> getCafeList() {
        // 반환할 것 (List -> CafeResponse)
        // Cafe, !!!totalCount (카페의 Menu 별 stock 합계)

        // 모든 카페를 불러온다. 단, 당일 updatedAt 내용만 조회
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime nowOfDay = LocalDate.now().atTime(LocalTime.MAX);
        List<Cafe> cafeList = cafeRepository.findAllByUpdatedAtBetween(startOfDay, nowOfDay);

        List<CafeResponse> responseList = new ArrayList<>();
        for(Cafe cafe : cafeList) {
            Integer totalCount = 0;
            List<Menu> menuList = menuRepository.findByCafeIdAndUpdatedAtBetween(cafe.getId(), startOfDay, nowOfDay);
            for(Menu menu : menuList) {
                totalCount += menu.getStock();
            }

            CafeResponse response = CafeResponse.builder()
                    .id(cafe.getId())
                    .cafeName(cafe.getCafeName())
                    .addressCity(cafe.getAddressCity())
                    .addressDistrict(cafe.getAddressDistrict())
                    .addressDetail(cafe.getAddressDetail())
                    .open(cafe.getOpen())
                    .close(cafe.getClose())
                    .imageUrl(cafe.getImageUrl())
                    .totalCount(totalCount)
                    .updatedAt(cafe.getUpdatedAt())
                    .build();

            responseList.add(response);
        }

        return responseList;
    }

    @Transactional
    public CafeMenuResponse createDailyMenu(CafeMenuRequest menuRequest) {
        // Cafe 생성
        Cafe requestCafe = Cafe.builder()
                .cafeName(menuRequest.getCafeName())
                .addressCity(menuRequest.getAddressCity())
                .addressDistrict(menuRequest.getAddressDistrict())
                .addressDetail(menuRequest.getAddressDetail())
                .description(menuRequest.getDescription())
                .open(menuRequest.getOpen())
                .close(menuRequest.getClose())
                .imageUrl(menuRequest.getImageUrl())
                .build();

        Cafe newCafe = cafeRepository.save(requestCafe);

        // Menu 리스트 생성
        List<ItemDto> menuList = menuRequest.getMenu();
        List<ItemDto> newItemDtoList = new ArrayList<>();
        for(ItemDto itemDto : menuList){
            Menu requestMenu = Menu.builder()
                    .name(itemDto.getItemName())
                    .type(itemDto.getType())
                    .cost(itemDto.getCost())
                    .stock(itemDto.getStock())
                    .cafe(newCafe)
                    .build();
            Menu newMenu = menuRepository.save(requestMenu);

            // newMenu를 newItemDtoList에 저장하기
            ItemDto newItemDto = ItemDto.from(newMenu);
            newItemDtoList.add(newItemDto);
        }

        return CafeMenuResponse.from(newCafe, newItemDtoList);
    }

    public CafeMenuResponse getDailyMenu(Long cafeId) {
        // 전체 카페 정보
        Cafe cafe = cafeRepository.findById(cafeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 CafeId 입니다: " + cafeId));

        // List<ItemDto> menuList
        // 메뉴 중에 오늘 날짜인 것 모두 추출하기
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime nowOfDay = LocalDate.now().atTime(LocalTime.MAX);
        List<Menu> menuList= menuRepository.findByCafeIdAndCreatedAtBetween(cafeId, startOfDay, nowOfDay);
        if(menuList.isEmpty()) {
            throw new IllegalArgumentException(cafeId + "에서 새로 등록한 메뉴가 없습니다.");
        }

        List<ItemDto> itemList = new ArrayList<>();
        for(Menu menu : menuList){
            ItemDto item = ItemDto.builder()
                    .itemName(menu.getName())
                    .type(menu.getType())
                    .cost(menu.getCost())
                    .stock(menu.getStock())
                    .build();
            itemList.add(item);
        }

        return CafeMenuResponse.from(cafe, itemList);
    }
}
