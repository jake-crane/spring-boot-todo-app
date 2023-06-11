package com.jakecrane.springboottodoapp.repository;

import com.jakecrane.springboottodoapp.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

}