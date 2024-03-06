package com.example.spring_11200.repositories;

import com.example.spring_11200.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long>{
}