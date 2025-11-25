package com.awais.wallet.Service;

import com.awais.wallet.DTO.walletTransaction.WalletTransactionRequestDTO;
import com.awais.wallet.DTO.walletTransaction.WalletTransactionResponseDTO;
import com.awais.wallet.Entity.Orders;
import com.awais.wallet.Entity.Wallet;
import com.awais.wallet.Entity.WalletTransaction;
import com.awais.wallet.Exception.NotFoundException;
import com.awais.wallet.Repository.OrderRepository;
import com.awais.wallet.Repository.WalletRepository;
import com.awais.wallet.Repository.WalletTransactionRespository;
import org.springframework.stereotype.Service;

@Service
public class WalletTransactionService {

    private final WalletTransactionRespository walletTransactionRespository;
    private final WalletRepository walletRepository;
    private final OrderRepository orderRepository;

    public WalletTransactionService(WalletTransactionRespository walletTransactionRespository, WalletRepository walletRepository, OrderRepository orderRepository) {
        this.walletTransactionRespository = walletTransactionRespository;
        this.walletRepository = walletRepository;
        this.orderRepository = orderRepository;
    }

    public WalletTransactionResponseDTO createTransaction(WalletTransactionRequestDTO walletTransactionRequestDTO) {

        Wallet wallet = walletRepository.findById(walletTransactionRequestDTO.wallet_id())
                .orElseThrow(() -> new NotFoundException("Wallet not found with this id"));


        Orders order = walletTransactionRequestDTO.order_id() != null
                ? orderRepository.findById(walletTransactionRequestDTO.order_id()).orElse(null)
                : null;


        WalletTransaction walletTransaction = new WalletTransaction();
        walletTransaction.setWallet(wallet);
        walletTransaction.setType(walletTransactionRequestDTO.type());
        walletTransaction.setAmount(walletTransactionRequestDTO.amount());
        walletTransaction.setBalance_before(wallet.getBalance());
        walletTransaction.setBalance_after(wallet.getBalance() + walletTransactionRequestDTO.amount());
        walletTransaction.setOrders(order);

        WalletTransaction saved = walletTransactionRespository.save(walletTransaction);


        return new WalletTransactionResponseDTO(
                saved.getId(),
                saved.getWallet(),
                saved.getType(),
                saved.getAmount(),
                saved.getBalance_before(),
                saved.getBalance_after(),
                saved.getOrders(),
                saved.getCreated_at()
        );
    }
}
