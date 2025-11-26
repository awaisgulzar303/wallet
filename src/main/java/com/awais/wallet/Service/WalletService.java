package com.awais.wallet.Service;


import com.awais.wallet.DTO.wallet.WalletRequestDTO;
import com.awais.wallet.DTO.wallet.WalletResponseDTO;
import com.awais.wallet.Entity.Users;
import com.awais.wallet.Entity.Wallet;
import com.awais.wallet.Exception.NotFoundException;
import com.awais.wallet.Repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public WalletResponseDTO createWallet(WalletRequestDTO walletRequestDTO) {
        Wallet wallet = new Wallet();
        Users user = new Users();
        user.setId(walletRequestDTO.user_id());

        wallet.setUsers(user);
        wallet.setBalance(walletRequestDTO.balance());
        Wallet saved = walletRepository.save(wallet);

        return new WalletResponseDTO(saved.getId(), saved.getUsers(), saved.getBalance(), saved.getVersion(), saved.getCreated_at(), saved.getUpdated_at());
    }

    public Map<String, Float> getBalanceByUserId(UUID user_id) {

        Wallet wallet = walletRepository.findByUsers_Id(user_id)
                .orElseThrow(() -> new NotFoundException("Wallet not found for user id: " + user_id));

        return Map.of("balance", wallet.getBalance());
    }

}
