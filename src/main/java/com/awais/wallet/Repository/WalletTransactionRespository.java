package com.awais.wallet.Repository;

import com.awais.wallet.Entity.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WalletTransactionRespository extends JpaRepository<WalletTransaction, UUID> {
}
