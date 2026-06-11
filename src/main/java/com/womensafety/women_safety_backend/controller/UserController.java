package com.womensafety.women_safety_backend.controller;

import com.womensafety.women_safety_backend.dto.LoginRequest;
import com.womensafety.women_safety_backend.dto.LoginResponseDTO;
import com.womensafety.women_safety_backend.dto.UserResponseDTO;
import com.womensafety.women_safety_backend.entity.User;
import com.womensafety.women_safety_backend.security.JwtUtil;
import com.womensafety.women_safety_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")   // ✅ CORS FIX (MOST IMPORTANT)
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    // ✅ REGISTER API
    @PostMapping("/register")
    public UserResponseDTO registerUser(@RequestBody User user) {

        User savedUser = userService.registerUser(user);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getRole()
        );
    }

    // ✅ LOGIN API (JWT)
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody LoginRequest request) {

        User user = userService.loginUser(
                request.getEmail(),
                request.getPassword()
        );

        // generate JWT token
        String token = jwtUtil.generateToken(user.getEmail());

        return new LoginResponseDTO(token, user.getEmail());
    }
}
