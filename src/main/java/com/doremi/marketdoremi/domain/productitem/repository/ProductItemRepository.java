package com.doremi.marketdoremi.domain.productitem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doremi.marketdoremi.codes.ItemLowerLevel;
import com.doremi.marketdoremi.codes.ItemUpperLevel;
import com.doremi.marketdoremi.domain.productitem.entity.ProductItem;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

    public List<ProductItem> findAllByUpperLevelAndLowerLevelOrderByIdDesc(ItemUpperLevel upperLevel, ItemLowerLevel lowerLevel);

    Optional<ProductItem> findOneByIdAndUpperLevelAndLowerLevelOrderByIdDesc(Long id, ItemUpperLevel upperLevel, ItemLowerLevel lowerLevel);
}
