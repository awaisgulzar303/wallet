package com.awais.wallet.Controller;

import com.awais.wallet.DTO.walletTransaction.WalletTransactionRequestDTO;
import com.awais.wallet.DTO.walletTransaction.WalletTransactionResponseDTO;
import com.awais.wallet.Service.WalletTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/walletTransaction")
public class WalletTransactionController {
    private final WalletTransactionService walletTransactionService;

    public WalletTransactionController(WalletTransactionService walletTransactionService) {
        this.walletTransactionService = walletTransactionService;
    }

    @PostMapping
    public ResponseEntity<WalletTransactionResponseDTO> createTransaction(@RequestBody WalletTransactionRequestDTO walletTransactionRequestDTO) {
        return ResponseEntity.status(201).body(walletTransactionService.createTransaction(walletTransactionRequestDTO));

    }
}
