package com.example.springdocker.mapper;

import com.example.springdocker.domain.ToDo;
import com.example.springdocker.model.ToDoDTO;
import org.springframework.stereotype.Service;

@Service
public class ToDoMapperImpl implements ToDoMapper {

    public ToDoDTO makeToDoDTO(ToDo toDo) {
        ToDoDTO todoDTO = new ToDoDTO();
        todoDTO.setId(toDo.getId());
        todoDTO.setText(toDo.getText());
        todoDTO.setStatus(toDo.getStatus());
        return todoDTO;
    }

    public ToDo makeToDoEntity(ToDoDTO todoDTO) {
        ToDo toDo = new ToDo();
        toDo.setId(todoDTO.getId());
        toDo.setText(todoDTO.getText());
        toDo.setStatus(todoDTO.getStatus());
        return toDo;
    }
}
