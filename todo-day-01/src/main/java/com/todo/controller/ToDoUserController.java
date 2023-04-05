package com.todo.controller;

import com.todo.entity.TodoUser;
import com.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todo/")
public class ToDoUserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/user")
    public TodoUser addUser(@RequestBody TodoUser todoUser) {
        String encodedPassword = passwordEncoder.encode(todoUser.getPassword());
        TodoUser user = new TodoUser(todoUser.getUsername(), encodedPassword);
        user.setRole(todoUser.getRole());
        return userRepository.save(user);
    }
}
