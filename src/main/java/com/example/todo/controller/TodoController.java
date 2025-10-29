package com.example.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dto.TodoRequest;
import com.example.todo.dto.TodoResponse;
import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.todo.security.UserPrincipal;



@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoResponse> create(
        @AuthenticationPrincipal UserPrincipal userDetails,
        @RequestBody TodoRequest request) {
            Todo created = todoService.createTodo(userDetails.getId(), request.getTitle(), request.getDescription());
        
            TodoResponse response = new TodoResponse(created.getId(), created.getTitle(), created.getDescription(), created.getCompleted());
            return ResponseEntity.ok(response);
        }
}
