package com.example.project3.cafe.service;

import com.example.project3.cafe.domain.Cafe;
import com.example.project3.cafe.dto.*;
import com.example.project3.cafe.repository.CafeRepository;
import com.example.project3.menu.domain.Menu;
import com.example.project3.menu.repository.MenuRepository;
import com.example.project3.menuCategory.domain.MenuCategory;
import com.example.project3.menuCategory.repository.MenuCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class CafeServiceImpl implements CafeService {
    CafeRepository cafeRepository;
    MenuRepository menuRepository;
    MenuCategoryRepository menuCategoryRepository;

    CafeServiceImpl(CafeRepository cafeRepository, MenuRepository menuRepository, MenuCategoryRepository menuCategoryRepository){
        this.cafeRepository = cafeRepository;
        this.menuRepository = menuRepository;
        this.menuCategoryRepository = menuCategoryRepository;
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
            // 각 itemDto를 menu에 저장하기
            MenuCategory menuCategory = menuCategoryRepository.findById(itemDto.getTypeId())
                    .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 MenuCategory 입니다: " + itemDto.getTypeId()));

            Menu requestMenu = Menu.builder()
                    .name(itemDto.getItemName())
                    .cost(itemDto.getCost())
                    .stock(itemDto.getStock())
                    .cafe(newCafe)
                    .menuCategory(menuCategory)
                    .build();
            Menu newMenu = menuRepository.save(requestMenu);

            // newMenu를 newItemDtoList에 저장하기
            ItemDto newItemDto = ItemDto.from(newMenu);
            newItemDtoList.add(newItemDto);
        }

        return CafeMenuResponse.from(newCafe, newItemDtoList);
    }
}
