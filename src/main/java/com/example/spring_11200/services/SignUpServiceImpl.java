package com.example.spring_11200.services;

import com.example.spring_11200.dto.UserForm;
import com.example.spring_11200.models.Role;
import com.example.spring_11200.models.State;
import com.example.spring_11200.models.User;
import com.example.spring_11200.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SmsService smsService;

    @Autowired
    private MailService mailService;

    @Override
    public void addUser(UserForm form) {
        User user = User.builder()
                .email(form.getEmail())
                .password(passwordEncoder.encode(form.getPassword()))
                .firstName(form.getFirstname())
                .lastName(form.getLastname())
                .role(Role.USER)
                .phone(form.getPhone())
                .state(State.CONFIRMED)
                .confirmedCode(UUID.randomUUID().toString())
                .build();
        usersRepository.save(user);
        smsService.sendSms(form.getPhone(), "Вы зарегестрированы!");
        mailService.sendEmailForConfirm(user.getEmail(), user.getConfirmedCode());
    }
}