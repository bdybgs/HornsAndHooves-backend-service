package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.exceprion.UserAlreadyExistException;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    // ResponseEntity<...Dto>
    // RestExceptionHandler
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно создан");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Не удалось создать пользователя");
        }
    };

    @GetMapping
    public ResponseEntity getUsers() {
        try {
            return ResponseEntity.ok("Сервер работает");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Произошла ошибка");
        }
    }

}
