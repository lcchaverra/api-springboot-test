// package com.example.baseapi.DTO.Users;

// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;

// public class UserCreateDTO {
//     @NotBlank(message = "El nombre de usuario es requerido")
//     @Size(min = 3, max = 20, message = "El nombre de usuario debe tener entre 3 y 20 caracteres")
//     private String username;

//     @NotBlank(message = "El correo es requerido")
//     @Email(message = "El correo no es válido")
//     private String email;   
    
//     @NotBlank(message = "La contraseña es requerida")
//     @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
//     private String password;

//     private int rol;

//     public String getUsername() {return username;}
//     public String getEmail() {return email;}
//     public String getPassword() {return password;}
//     public int getRol() {return rol;}
// }
