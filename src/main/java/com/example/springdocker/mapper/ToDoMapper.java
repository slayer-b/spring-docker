package com.example.springdocker.mapper;

import com.example.springdocker.domain.ToDo;
import com.example.springdocker.model.ToDoDTO;

public interface ToDoMapper {

    ToDoDTO makeToDoDTO(ToDo toDo);

    ToDo makeToDoEntity(ToDoDTO categoryDTO);
}
