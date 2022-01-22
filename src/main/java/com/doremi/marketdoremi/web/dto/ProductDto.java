package com.doremi.marketdoremi.web.dto;

import com.doremi.marketdoremi.codes.*;
import com.doremi.marketdoremi.domain.productitem.entity.ProductItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 상품 dto
 */
@Getter @Setter
public class ProductDto {

    private ItemUpperLevel upperLevel;//상위 분류코드
    private ItemLowerLevel lowerLevel;//하위 분류코드
    private String name;//상품명
    private String description;//간략설명
    private long price;//가격
    private String unit;//판매단위
    private String volume;//중량,용량
    private String origin;//원산지
    private String allergyInfo;//알레르기정보
    private ItemPackagingType packagingType;//포장박스
    private ItemTemperatureType temperatureType;//포장온도
    private List<DeliveryType> deliveryType;//배송구분
    //TODO 상세정보 이미지 파일
    private ItemStatus status;

    public ProductItem toEntity() throws Exception {

        String deliveryTypes = deliveryType.stream()
                .map(type -> type.name())
                .collect(Collectors.joining(","));

        return ProductItem.builder()
                .upperLevel(upperLevel)
                .lowerLevel(lowerLevel)
                .name(name)
                .description(description)
                .price(price)
                .unit(unit)
                .volume(volume)
                .origin(origin)
                .allergyInfo(allergyInfo)
                .packagingType(packagingType)
                .temperatureType(temperatureType)
                .deliveryType(deliveryTypes)
                .build();
    }
}
