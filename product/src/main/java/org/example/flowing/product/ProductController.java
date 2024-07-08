package org.example.flowing.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct (@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(this.productService.createProduct(productDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts () {
        return ResponseEntity.ok(this.productService.getAllProducts());
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct (@PathVariable String productId) {
        productService.deleteProduct(productId);
    }
}
