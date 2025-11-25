package com.awais.wallet.DTO.walletTransaction;

import com.awais.wallet.Entity.Orders;
import com.awais.wallet.Entity.TransactionType;
import com.awais.wallet.Entity.Wallet;

import java.util.Date;
import java.util.UUID;

public record WalletTransactionResponseDTO(
        UUID id,
        Wallet wallet,
        TransactionType type,
        float amount,
        float balance_before,
        float balance_after,
        Orders orders,
        Date created_at

) {
}
