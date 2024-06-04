package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exceprion.UserAlereadyExistException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlereadyExistException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new UserAlereadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepository.save(user);
    }

}