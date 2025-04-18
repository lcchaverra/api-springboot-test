package com.example.baseapi.Controller.Auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.baseapi.Model.Users.Users;
import com.example.baseapi.Service.Auth.AuthService;
import com.example.baseapi.Utils.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("auth")
public class AuthController {
    private final AuthService authService;

    public AuthController (AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> authUser(@RequestBody Users user) {
        Users loggedUser = authService.Login(user.getId(), user.getUsername(), user.getPassword());
        if (loggedUser.toString().length()>0){
            return ResponseEntity.ok().body(new ApiResponse<>("Inicio de Sessión Exitoso", "token"));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("No se pudo encontrar el usuario", "NA"));
        }
    }
    
}
