package com.example.baseapi.Controller.Users;

// import com.example.baseapi.DTO.Users.UserCreateDTO;
// import com.example.baseapi.DTO.Users.UserDTO;
// import com.example.baseapi.DTO.Users.UserUpdateDTO;
import com.example.baseapi.Model.Users.Users;
import com.example.baseapi.Service.Users.UsersService;
import com.example.baseapi.Utils.ApiResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService userservice;

    public UsersController (UsersService userservice){
        this.userservice = userservice;
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Users>>> getAllUsers(){
        List<Users> users = userservice.getAllUsers();
        return ResponseEntity.ok(new ApiResponse<>("Usuarios obtenidos con éxito", users));
        // return ResponseEntity.ok(new ApiResponse<>("Usuarios obtenidos con éxito", userservice.getAllUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Users>> getUser(@PathVariable int id){
        Users user = userservice.getUser(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("Usuario no encontrado", null));
        }
        return ResponseEntity.ok(new ApiResponse<>("Usuario obtenido con éxito", user));
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<Users>> createUser(@RequestBody Users user){
        Users createdUser = userservice.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>("Usuario creado con éxito", createdUser));
    }

    // @PostMapping("/")
    // public ResponseEntity<ApiResponse<UserDTO>> createUser(@RequestBody UserCreateDTO userDto) {
    //     return ResponseEntity.ok(new ApiResponse<>("Usuario creado", userservice.createUser(userDto)));
    // }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Users>> updateUser(@PathVariable int id, @RequestBody Users user){
        Users userUpdated = userservice.updateUser(id,user);
        return ResponseEntity.ok().body(new ApiResponse<>("Usuario actualizado con éxito", userUpdated));
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<ApiResponse<UserDTO>> updateUser(@PathVariable int id, @RequestBody UserUpdateDTO userDto) {
    //     UserDTO updatedUser = userservice.updateUser(id, userDto);
    //     if (updatedUser == null) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     return ResponseEntity.ok(new ApiResponse<>("Usuario actualizado", updatedUser));
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable int id){
        boolean deleted = userservice.deleteUser(id);
        if (deleted) {
            return ResponseEntity.ok().body(new ApiResponse<>("Usuario eliminado con éxito", null));
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>("Usuario no encontrado", null));
        }
    }
}
