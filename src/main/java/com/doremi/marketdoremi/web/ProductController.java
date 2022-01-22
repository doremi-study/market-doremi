package com.doremi.marketdoremi.web;

import com.doremi.marketdoremi.web.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/product")
public class ProductController {

    /**
     * 상품 생성
     * @return
     */
    @PostMapping(value = "item")
    public ResponseEntity<String> registItem(@RequestBody ProductDto product) {
        log.info("product ::: {}", product);
        return ResponseEntity.ok("");
    }

    /**
     * 상품 내용 수정 (visible 상관없을듯)
     * @return
     */
    @PutMapping(value = "item")
    public ResponseEntity<String> modifyItem(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok("");
    }

    /**
     * 상품 visible 상태를 안보이게
     * @return
     */
    @RequestMapping(value = "status")
    public ResponseEntity<String> changeStatus() {

        return ResponseEntity.ok("");
    }
}
