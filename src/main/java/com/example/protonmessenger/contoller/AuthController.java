package com.example.protonmessenger.contoller;

import com.example.protonmessenger.model.ApiResponse;
import com.example.protonmessenger.model.User;
import com.example.protonmessenger.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try{
            String token = authService.login(user.getName(), user.getPassword());
            if (token != null) {
                return ResponseEntity.ok().body(ApiResponse.success(token));
            }else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.failure("Not logged In"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.failure(e.getMessage()));
        }

    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody User user) {
        try{
            authService.logout(user.getName());
            return ResponseEntity.ok().body(ApiResponse.success("logged out successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.failure(e.getMessage()));
        }

    }
}