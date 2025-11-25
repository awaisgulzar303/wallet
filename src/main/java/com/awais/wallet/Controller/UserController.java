package com.awais.wallet.Controller;

import com.awais.wallet.DTO.user.UserRequestDTO;
import com.awais.wallet.DTO.user.UserResponseDTO;
import com.awais.wallet.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.createUser(userRequestDTO));
    }
}
