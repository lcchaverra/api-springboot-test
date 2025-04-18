package com.example.baseapi.repository.Users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.baseapi.Model.Users.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
}
