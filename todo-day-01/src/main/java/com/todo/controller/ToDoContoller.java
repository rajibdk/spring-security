package com.todo.controller;

import org.springframework.web.bind.annotation.*;

import com.todo.entity.ToDo;

@RestController
@RequestMapping("todo/")
public class ToDoContoller {
	
	@GetMapping("/view")
	public String getTodoList() {
		return "List of todo items";
	}
	
	@PostMapping("/add")
	public String addTodo(@RequestBody ToDo todo) {
		return "Todo Added " + todo;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteToDo() {
		return "Delete todo item";
	}
	
	@PutMapping("/update/{id}")
	public String updateTodo() {
		return "Update todo item";
	}
}
