package com.awais.wallet.DTO.user;

import com.awais.wallet.Entity.Role;

public record UserRequestDTO(
        String email, String full_name, Role role
) {
}
