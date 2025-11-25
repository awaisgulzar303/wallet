package com.awais.wallet.Controller;


import com.awais.wallet.DTO.inventory.InventoryRequestDTO;
import com.awais.wallet.DTO.inventory.InventoryResponseDTO;
import com.awais.wallet.Service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @PostMapping
    public ResponseEntity<InventoryResponseDTO> createInventory(@RequestBody InventoryRequestDTO inventoryRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(inventoryService.createInventory(inventoryRequestDTO));
    }
}
