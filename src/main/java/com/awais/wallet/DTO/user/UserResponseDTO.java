package com.awais.wallet.DTO.user;

import com.awais.wallet.Entity.Role;

import java.util.Date;
import java.util.UUID;

public record UserResponseDTO(UUID id, String email, String full_name, Role role, Date created_at, Date updated_at) {
}
