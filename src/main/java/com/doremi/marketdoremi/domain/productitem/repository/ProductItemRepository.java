package com.doremi.marketdoremi.domain.productitem.repository;

import com.doremi.marketdoremi.domain.productitem.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
