package com.example.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    /** Find all todos by user id */
    List<Todo> findByUserId(Long userId);

    /** Find all todos by user id and completed is false */
    List<Todo> findByUserIdAndCompletedFalse(Long userId);

    /** Find all todos by user id and completed is true */
    List<Todo> findByUserIdAndCompletedTrue(Long userId);
}
