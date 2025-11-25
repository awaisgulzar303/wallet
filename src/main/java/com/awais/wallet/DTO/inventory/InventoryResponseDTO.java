package com.awais.wallet.DTO.inventory;

import com.awais.wallet.Entity.Users;

import java.util.Date;
import java.util.UUID;

public record InventoryResponseDTO(

        UUID id,
        String name,
        Users users,
        double price,
        int stock_quantity,
        Date created_at,
        Date updated_at) {
}
