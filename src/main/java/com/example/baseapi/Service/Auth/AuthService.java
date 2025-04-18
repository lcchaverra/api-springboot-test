package com.example.baseapi.Service.Auth;

import org.springframework.stereotype.Service;

import com.example.baseapi.Model.Users.Users;
import com.example.baseapi.repository.Users.UsersRepository;

@Service
public class AuthService {
    private final UsersRepository userRepository;

    public AuthService (UsersRepository userRepository){
        this.userRepository = userRepository;
    }

    public Users Login(int id,String userName,String password){
        // return userRepository.findBy("Select * from Users where username = ? and password = ?", )
        return userRepository.findById(id).orElse(null);
    }
    
}
