package com.awais.wallet.DTO.walletTransaction;

import com.awais.wallet.Entity.Type;

import java.util.UUID;

public record WalletTransactionRequestDTO(
        UUID wallet_id,
        Type type,
        float amount,
        float balance_before,
        float balance_after,
        UUID order_id

) {
}
