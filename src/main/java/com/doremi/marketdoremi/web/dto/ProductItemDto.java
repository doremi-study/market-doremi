package com.doremi.marketdoremi.web.dto;

import com.doremi.marketdoremi.codes.ItemLowerLevel;
import com.doremi.marketdoremi.codes.ItemUpperLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * 상품 검색용 dto
 */
@Getter @Setter
public class ProductItemDto {

    private ItemUpperLevel upperLevel;
    private ItemLowerLevel lowerLevel;
    private Long id;//  TODO 역시 상품코드 있는게 나아보임 바꾸기.
}
