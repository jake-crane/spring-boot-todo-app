package com.jakecrane.springboottodoapp.repository;

import com.jakecrane.springboottodoapp.entity.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    Todo findById(long id);
}