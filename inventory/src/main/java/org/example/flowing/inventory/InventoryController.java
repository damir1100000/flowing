package org.example.flowing.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    private ResponseEntity<ItemDTO> createInventoryItem (@RequestBody ItemDTO itemDTO) {
        return ResponseEntity.ok(this.inventoryService.createItem(itemDTO));
    }

    @GetMapping
    private ResponseEntity<List<ItemDTO>> getAllItems () {
        return ResponseEntity.ok(this.inventoryService.getAllItems());
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ItemDTO> updateQuantity(@PathVariable String productId, @RequestBody int quantity) {
        return ResponseEntity.ok(this.inventoryService.updateQuantity(productId, quantity));
    }
}
