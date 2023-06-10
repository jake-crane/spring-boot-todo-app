package com.jakecrane.springboottodoapp.controller;

import com.jakecrane.springboottodoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.jakecrane.springboottodoapp.entity.Todo;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoRepository toDoRepository;
    @GetMapping()
    public Iterable<Todo> getAllTodos() {
        return toDoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Todo findOne(@PathVariable Long id) {
        return toDoRepository.findById(id).orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo create(@RequestBody Todo todo) {
        return toDoRepository.save(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@RequestBody Todo todo, @PathVariable Long id) throws Exception {
        if (todo.getId() != id) {
            throw new Exception("Path id and request id do not match");
        }
        toDoRepository.findById(id).orElseThrow();
        return toDoRepository.save(todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        toDoRepository.findById(id).orElseThrow();
        toDoRepository.deleteById(id);
    }

}