package com.awais.wallet.DTO.wallet;


import com.awais.wallet.Entity.Users;

import java.util.Date;
import java.util.UUID;

public record WalletResponseDTO(
        UUID id,
        Users users,
        float balance,
        int version,
        Date created_at,
        Date updated_at
) {
}
