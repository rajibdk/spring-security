package com.todo.repository;

import com.todo.entity.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<TodoUser, Integer> {
    List<TodoUser> findTodoUserByUsername(String username);
}
