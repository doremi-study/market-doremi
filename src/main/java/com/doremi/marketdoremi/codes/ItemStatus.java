package com.doremi.marketdoremi.codes;

/**
 * 상품 상태 - 상품의 상태와 사용자 공개 여부 결정짓도록
 * 판매가능 : 등록 직후
 * 판매중 : 사용자 공개
 * 품절 : 사용자 공개 & 판매 불가
 * 공급중지(좀 더 좋은 명칭 있을것같은데) : 사용자 비공개
 */
public enum ItemStatus {

    READY,
    FOR_SALE,
    OUT_OF_STOCK,
    STOP_SUPPLY
    ;
}
