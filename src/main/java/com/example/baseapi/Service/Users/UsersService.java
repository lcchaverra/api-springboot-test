package com.example.baseapi.Service.Users;
// import com.example.baseapi.DTO.Users.UserCreateDTO;
// import com.example.baseapi.DTO.Users.UserDTO;
// import com.example.baseapi.DTO.Users.UserUpdateDTO;
import com.example.baseapi.Model.Users.Users;
import com.example.baseapi.repository.Users.UsersRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
// import java.util.stream.Collectors;

@Service
public class UsersService {
    private final UsersRepository userRepository;

    public UsersService (UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    // public List<UserDTO> getAllUsers() {
    //     return userRepository.findAll().stream()
    //             .map(user -> new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getRol()))
    //             .collect(Collectors.toList());
    // }

    public Users getUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    // public UserDTO getUser(int id) {
    //     Optional<Users> user = userRepository.findById(id);
    //     return user.map(u -> new UserDTO(u.getId(), u.getUsername(), u.getEmail(), u.getRol()))
    //                .orElse(null);
    // }

    public Users createUser(Users user){
        return userRepository.save(user);
    }

    // public UserDTO createUser(UserCreateDTO userDto) {
    //     Users user = new Users();
    //     user.setUsername(userDto.getUsername());
    //     user.setEmail(userDto.getEmail());
    //     user.setPassword(userDto.getPassword());
    //     user.setRol(userDto.getRol());

    //     Users savedUser = userRepository.save(user);
    //     return new UserDTO(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail(), savedUser.getRol());
    // }

    public Users updateUser (int id, Users user){
        Optional<Users> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            Users userToUpdate = existingUser.get();
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setRol(user.getRol());
            userToUpdate.setUpdated_at(user.getUpdated_at());
            userRepository.save(userToUpdate);
            return userToUpdate;
        }
        return null;
    }

    // public UserDTO updateUser(int id, UserUpdateDTO userDto) {
    //     Optional<Users> existingUser = userRepository.findById(id);
    //     if (existingUser.isPresent()) {
    //         Users user = existingUser.get();
    //         user.setUsername(userDto.getUsername());
    //         user.setEmail(userDto.getEmail());
    //         user.setRol(userDto.getRol());

    //         Users updatedUser = userRepository.save(user);
    //         return new UserDTO(updatedUser.getId(), updatedUser.getUsername(), updatedUser.getEmail(), updatedUser.getRol());
    //     }
    //     return null;
    // }

    public boolean deleteUser (int id){
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
