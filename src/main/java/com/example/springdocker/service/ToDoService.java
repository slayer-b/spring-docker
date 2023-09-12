package com.example.springdocker.service;


import com.example.springdocker.model.ToDoDTO;

import java.util.List;
import java.util.Optional;

public interface ToDoService {

    List<ToDoDTO> getToDos();

    Optional<ToDoDTO> getToDo(Long id);

    ToDoDTO create(ToDoDTO dto);

    ToDoDTO update(ToDoDTO dto);

    void delete(Long id);
}
