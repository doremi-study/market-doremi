package com.doremi.marketdoremi.web;

import com.doremi.marketdoremi.domain.productitem.entity.ProductItem;
import com.doremi.marketdoremi.service.product.ProductService;
import com.doremi.marketdoremi.web.dto.ProductDto;
import com.doremi.marketdoremi.web.dto.ProductItemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 상품 생성
     * @return
     */
    @PostMapping(value = "/admin/item")
    public ResponseEntity registItem(@RequestBody ProductDto product) throws Exception {
        productService.saveItem(product);
        return ResponseEntity.ok().build();
    }

    /**
     * 상품 내용 수정 (status 상관없을듯)
     * @return
     */
    @PutMapping(value = "/admin/item")
    public ResponseEntity modifyItem(@RequestBody ProductDto product) throws Exception {
        productService.updateItem(product);
        return ResponseEntity.ok().build();
    }

    /**
     * 상품 status 변경
     * @return
     */
    @PutMapping(value = "/admin/status")
    public ResponseEntity changeStatus(@RequestBody ProductDto product) throws Exception {
        //  TODO 상품 등록 변경시 이력 테이블 있어야하지않을까. 재고는 지금 없으니까 등록할 떄,상태 변할 때만?
        productService.updateStatus(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/items")
    public ResponseEntity<List<ProductItem>> selectItems(@RequestBody ProductItemDto productItem) throws Exception {
        List<ProductItem> items = productService.selectItems(productItem);
        return ResponseEntity.ok(items);
    }

    @GetMapping(value = "/item")
    public ResponseEntity<ProductItem> selectItem(@RequestBody ProductItemDto productItem) throws Exception {
        ProductItem item = productService.selectItem(productItem);
        return ResponseEntity.ok(item);
    }
}
