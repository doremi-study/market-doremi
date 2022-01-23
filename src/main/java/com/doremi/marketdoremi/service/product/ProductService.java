package com.doremi.marketdoremi.service.product;

import com.doremi.marketdoremi.codes.ItemStatus;
import com.doremi.marketdoremi.domain.productitem.entity.ProductItem;
import com.doremi.marketdoremi.domain.productitem.repository.ProductItemRepository;
import com.doremi.marketdoremi.web.dto.ProductDto;
import com.doremi.marketdoremi.web.dto.ProductItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductItemRepository productItemRepository;

    public void saveItem(ProductDto product) throws Exception {
        ProductItem productItem = product.toEntity();
        productItem.setStatus(ItemStatus.READY);

        productItemRepository.save(productItem);
    }

    public void updateItem(ProductDto product) throws Exception {
        ProductItem productItem = product.toEntityWithId();

        ProductItem originProductItem = productItemRepository.findById(product.getId())
                .orElseThrow(() -> new Exception("수정하려는 상품과 일치하는 상품이 존재하지 않습니다."));

        productItemRepository.save(productItem);
    }

    public void updateStatus(ProductDto product) throws Exception {
        ProductItem originProductItem = productItemRepository.findById(product.getId())
                .orElseThrow(() -> new Exception("수정하려는 상품과 일치하는 상품이 존재하지 않습니다."));
        originProductItem.setStatus(product.getStatus());

        productItemRepository.save(originProductItem);
    }

    public List<ProductItem> selectItems(ProductItemDto productItem) {
        return productItemRepository.findAllByUpperLevelAndLowerLevelOrderByIdDesc(productItem.getUpperLevel(), productItem.getLowerLevel());
    }

    public ProductItem selectItem(ProductItemDto productItem) throws Exception {
        return (ProductItem) productItemRepository.findOneByIdAndUpperLevelAndLowerLevelOrderByIdDesc(productItem.getId(), productItem.getUpperLevel(), productItem.getLowerLevel())
                .orElseThrow(() -> new Exception("해당하는 상품이 존재하지 않습니다."));
    }
}
