package com.doremi.marketdoremi.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doremi.marketdoremi.codes.ItemStatus;
import com.doremi.marketdoremi.common.error.exceptions.DoremiRuntimeException;
import com.doremi.marketdoremi.domain.productitem.entity.ProductItem;
import com.doremi.marketdoremi.domain.productitem.repository.ProductItemRepository;
import com.doremi.marketdoremi.web.dto.ProductDto;
import com.doremi.marketdoremi.web.dto.ProductItemDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductItemRepository productItemRepository;

    public void saveItem(ProductDto product) throws Exception {
        ProductItem productItem = product.toEntity();
        productItem.setStatus(ItemStatus.READY);
        productItemRepository.save(productItem);
    }

    public void updateItem(ProductDto productDto) throws Exception {
        isExistProductByProductId(productDto.getId());
        ProductItem productItem = productDto.toEntityWithId();
        productItemRepository.save(productItem);
    }

    public void updateStatus(ProductDto productDto) throws Exception {
        ProductItem productItem = toEntityProductItem(productDto);
        productItemRepository.save(productItem);
    }

    private ProductItem toEntityProductItem(ProductDto productDto) {
        ProductItem productItem = findByProductId(productDto.getId());
        productItem.setStatus(productDto.getStatus());
        return productItem;
    }

    public List<ProductItem> selectItems(ProductItemDto productItem) {
        return productItemRepository.findAllByUpperLevelAndLowerLevelOrderByIdDesc(productItem.getUpperLevel(), productItem.getLowerLevel());
    }

    public ProductItem selectItem(ProductItemDto productItem) throws Exception {
        return productItemRepository.findOneByIdAndUpperLevelAndLowerLevelOrderByIdDesc(productItem.getId(), productItem.getUpperLevel(), productItem.getLowerLevel())
                .orElseThrow(() -> new DoremiRuntimeException("해당하는 상품이 존재하지 않습니다."));
    }

    private ProductItem findByProductId(Long productId) {
        return productItemRepository.findById(productId)
                                .orElseThrow(() -> new DoremiRuntimeException("수정하려는 상품과 일치하는 상품이 존재하지 않습니다."));
    }

    private void isExistProductByProductId(Long productId) {
        findByProductId(productId);
    }
}
