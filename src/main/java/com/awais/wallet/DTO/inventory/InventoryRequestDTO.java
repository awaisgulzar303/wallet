package com.awais.wallet.DTO.inventory;

import java.util.UUID;

public record InventoryRequestDTO(

        String name,
        UUID vendor_id,
        double price,
        int stock_quantity


) {
}
