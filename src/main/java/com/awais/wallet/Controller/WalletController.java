package com.awais.wallet.Controller;

import com.awais.wallet.DTO.wallet.WalletRequestDTO;
import com.awais.wallet.DTO.wallet.WalletResponseDTO;
import com.awais.wallet.Service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final WalletService walletService;


    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public ResponseEntity<WalletResponseDTO> createWallet(@RequestBody WalletRequestDTO walletRequestDTO) {
        return ResponseEntity.status(201).body(walletService.createWallet(walletRequestDTO));
    }
}
