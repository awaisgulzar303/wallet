package com.awais.wallet.DTO.wallet;

import java.util.UUID;

public record WalletRequestDTO(
        UUID user_id,
        float balance
) {
}
