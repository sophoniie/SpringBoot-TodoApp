package com.example.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.model.Todo;
import com.example.todo.model.User;
import com.example.todo.repository.TodoRepository;
import com.example.todo.repository.UserRepository;


@Service
public class TodoService {

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    public TodoService(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    /**
     * Create a new todo for a user
     * @param userId the id of the user
     * @param title the title of the todo
     * @param description the description of the todo
     * @return the created todo
     */
    @Transactional
    public Todo createTodo(Long userId, String title, String description) {
        User user = userRepository.findById(userId)
        .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Todo todo = new Todo(title, description);
        user.addTodo(todo);

        userRepository.save(user);
        return todo;
    }

    /**
     * Get all todos for a user
     * @param userId the id of the user
     * @return the list of todos
     */
    @Transactional(readOnly = true)
    public List<Todo> getUserTodos(Long userId) {
        return todoRepository.findByUserId(userId);
    }

    @Transactional
    public void deleteTodo(Long userId, Long todoId) {
        Todo todo = todoRepository.findById(todoId)
        .orElseThrow(() -> new IllegalArgumentException("Todo not found"));

        if (todo.getUser() == null || !todo.getUser().getId().equals(userId)) {
            throw new IllegalArgumentException("User is not the owner of this todo");
        }

        todoRepository.delete(todo);
    }
}
