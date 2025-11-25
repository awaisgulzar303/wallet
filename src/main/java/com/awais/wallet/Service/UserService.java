package com.awais.wallet.Service;

import com.awais.wallet.DTO.user.UserRequestDTO;
import com.awais.wallet.DTO.user.UserResponseDTO;
import com.awais.wallet.Entity.Users;
import com.awais.wallet.Repository.UserRespository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRespository userRespository;

    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }


    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        Users user = new Users();
        user.setEmail(userRequestDTO.email());
        user.setFull_name(userRequestDTO.full_name());
        user.setRole(userRequestDTO.role());
        Users saved = userRespository.save(user);

        return new UserResponseDTO(saved.getId(), saved.getEmail(), saved.getFull_name(), saved.getRole(), saved.getCreated_at(), saved.getUpdated_at());
    }


}
