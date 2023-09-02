package com.todoproject.rest.webservices.restfulwebservices.todo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResources {
    public TodoService todoService;

    public TodoResources(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        return todoService.findByUsername(username);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public void deleteTodo(@PathVariable String username, @PathVariable int id) {
        todoService.deleteById(id);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable int id) {
        return todoService.findById(id);
    }

    @PutMapping("/users/{username}/todos/{id}")
    public void updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
        todoService.updateTodo(todo);
    }
}
