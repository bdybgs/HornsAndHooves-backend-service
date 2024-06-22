package com.example.demo.service;

import com.example.demo.entity.TodoEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.TodoRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;

    public TodoEntity createTodo (TodoEntity todoEntity, Long userId) {
        UserEntity userEntity = userRepository.findById(userId).get();
        todoEntity.setUser(userEntity);
        return todoRepository.save(todoEntity);
    }

    public TodoEntity complete (Long todoId) {
        TodoEntity todoEntity = todoRepository.findById(todoId).get();
        todoEntity.setCompleted(!todoEntity.getCompleted());
        return todoRepository.save(todoEntity);
    }
}
