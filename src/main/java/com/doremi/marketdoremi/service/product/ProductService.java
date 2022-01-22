package com.doremi.marketdoremi.service.product;

import com.doremi.marketdoremi.domain.productitem.entity.ProductItem;
import com.doremi.marketdoremi.domain.productitem.repository.ProductItemRepository;
import com.doremi.marketdoremi.web.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductItemRepository productItemRepository;

    public void saveItem(ProductDto product) throws Exception {
        ProductItem productItem = product.toEntity();
        ProductItem save = productItemRepository.save(productItem);
    }
}
