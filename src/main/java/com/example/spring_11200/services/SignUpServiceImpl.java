package com.example.spring_11200.services;

import com.example.spring_11200.dto.UserForm;
import com.example.spring_11200.models.User;
import com.example.spring_11200.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public void addUser(UserForm userForm) {
        User user = User.builder()
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .build();
        usersRepository.save(user);
    }
}