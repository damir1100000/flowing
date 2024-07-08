package org.example.flowing.inventory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<ItemEntity, Long> {
    Optional<ItemEntity> findByProductId (String productId);
}
