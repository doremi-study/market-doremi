package com.doremi.marketdoremi.web.dto;

import com.doremi.marketdoremi.codes.DeliveryType;
import com.doremi.marketdoremi.codes.ItemLowerLevel;
import com.doremi.marketdoremi.codes.ItemStatus;
import com.doremi.marketdoremi.codes.ItemUpperLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 상품 dto
 */
@Getter @Setter
public class ProductDto {

    ItemUpperLevel upperLevel;//상위 분류코드
    ItemLowerLevel lowerLevel;//하위 분류코드
    String name;//상품명
    String description;//간략설명
    long price;//가격
    String unit;//판매단위
    String volume;//중량,용량
    List<DeliveryType> deliveryType;//배송구분
    String origin;//원산지
    PackageDto packageData;//포장타입(온도/포장)
    String allergyInfo;//알레르기정보
    //TODO 상세정보 이미지 파일
    ItemStatus status;
}
