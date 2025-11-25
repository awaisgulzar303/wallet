package com.awais.wallet.Service;

import com.awais.wallet.DTO.inventory.InventoryRequestDTO;
import com.awais.wallet.DTO.inventory.InventoryResponseDTO;
import com.awais.wallet.Entity.Inventory;
import com.awais.wallet.Entity.Users;
import com.awais.wallet.Exception.AuthorizationException;
import com.awais.wallet.Exception.NotFoundException;
import com.awais.wallet.Repository.InventoryRepository;
import com.awais.wallet.Repository.UserRespository;
import org.springframework.stereotype.Service;


@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final UserRespository userRespository;

    public InventoryService(InventoryRepository inventoryRepository, UserRespository userRespository) {
        this.inventoryRepository = inventoryRepository;
        this.userRespository = userRespository;
    }

    public InventoryResponseDTO createInventory(InventoryRequestDTO dto) {


        Users user = userRespository.findById(dto.vendor_id())
                .orElseThrow(() -> new NotFoundException("User not found"));


        if (!"VENDOR".equalsIgnoreCase(String.valueOf(user.getRole()))) {
            throw new AuthorizationException("Only vendors can create inventory");
        }


        Inventory inv = new Inventory();
        inv.setUser(user);
        inv.setName(dto.name());
        inv.setPrice(dto.price());
        inv.setStock_quantity(dto.stock_quantity());

        Inventory saved = inventoryRepository.save(inv);
        return new InventoryResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getUser(),
                saved.getPrice(),
                saved.getStock_quantity(),
                saved.getCreated_at(),
                saved.getUpdated_at()
        );
    }
}
