package com.example.springdocker.model;

import java.util.List;

public class ToDoListDTO {

    List<ToDoDTO> toDos;

    public ToDoListDTO(List<ToDoDTO> toDos) {
        this.toDos = toDos;
    }

    public List<ToDoDTO> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDoDTO> toDos) {
        this.toDos = toDos;
    }
}
