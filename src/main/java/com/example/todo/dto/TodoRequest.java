package com.example.todo.dto;

public class TodoRequest {

    private String title;
    private String description;
    private boolean completed;

    public TodoRequest() { }

    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }

    public boolean getCompleted() { return this.completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
