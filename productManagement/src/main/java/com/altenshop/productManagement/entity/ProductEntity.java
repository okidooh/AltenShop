package com.altenshop.productManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private String code;

        private String name;
        private String description;
        private String image;
        private String category;
        private double price;
        private int quantity;
        private String internalReference;
        private Long shellId;

        @Enumerated(EnumType.STRING)
        private InventoryStatus inventoryStatus;

        private int rating;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        // InventoryStatus enum
        public enum InventoryStatus {
            INSTOCK, LOWSTOCK, OUTOFSTOCK
        }
}
