package com.doremi.marketdoremi.domain.productitem.entity;

import com.doremi.marketdoremi.codes.*;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor @AllArgsConstructor
@Getter @Builder
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(name = "product_item")
@Entity
public class ProductItem {

    //  TODO 상품코드가 따로 있어야할 것 같은데. 변하지않는 상품코드(유효성체크 가능)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //  TODO 일단 enum. 메뉴 안만들어서
    @Enumerated(EnumType.STRING)
    private ItemUpperLevel upperLevel;//상위 분류코드

    @Enumerated(EnumType.STRING)
    private ItemLowerLevel lowerLevel;//하위 분류코드

    private String name;//상품명

    private String description;//간략설명

    private long price;//가격

    private String unit;//판매단위

    private String volume;//중량,용량

    private String origin;//원산지

    @Lob
    private String allergyInfo;//알레르기정보

    @Enumerated(EnumType.STRING)
    private ItemTemperatureType temperatureType;

    @Enumerated(EnumType.STRING)
    private ItemPackagingType packagingType;

    private String deliveryType;

    //TODO 상세정보 이미지 파일

    @Enumerated(EnumType.STRING)
    private ItemStatus status;
}
