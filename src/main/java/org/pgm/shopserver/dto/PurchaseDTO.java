package org.pgm.shopserver.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pgm.shopserver.model.Role;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDTO {
    private Long id;
    private String username;
    private Long productId;
    private Integer quantity;
    private LocalDateTime purchaseTime;
}
