package com.example.demo.controller;

import com.example.demo.entity.TodoEntity;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;
    @PostMapping()
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId) {
        try {
           return ResponseEntity.ok(todoService.createTodo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PutMapping()
    public ResponseEntity completeTodo(@RequestParam Long todoId) {
        try {
            return ResponseEntity.ok(todoService.complete(todoId));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
