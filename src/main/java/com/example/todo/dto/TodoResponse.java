package com.example.todo.dto;

public class TodoResponse {

    private Long id;
    private String title;
    private String description;
    private boolean completed;

    public TodoResponse(Long id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public Long getId() { return this.id; }
    public String getTitle() { return this.title; }
    public String getDescription() { return this.description; }
    public boolean getCompleted() { return this.completed; }
}
