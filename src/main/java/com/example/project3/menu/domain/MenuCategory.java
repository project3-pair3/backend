package com.example.project3.menu.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MenuCategory {
    CAKE(1),
    MACARON(2),
    TART(3),
    PUDDING(4),
    COOKIE(5);

    private final int typeId;

    @JsonValue // 출력용 (Enum -> JSON)
    public int getTypeId() {
        return typeId;
    }

    @JsonCreator // 입력용 (JSON 숫자 -> Enum)
    public static MenuCategory fromTypeId(int typeId) {
        for(MenuCategory menuCategory : MenuCategory.values()) {
            if(menuCategory.getTypeId() == typeId) {
                return menuCategory;
            }
        }

        throw new IllegalArgumentException("존재하지 않는 메뉴 대분류 id입니다: " + typeId);
    }
}
