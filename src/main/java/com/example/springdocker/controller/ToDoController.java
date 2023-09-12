package com.example.springdocker.controller;

import com.example.springdocker.model.ToDoDTO;
import com.example.springdocker.model.ToDoListDTO;
import com.example.springdocker.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(ToDoController.BASE_URL)
public class ToDoController {

    /**
     * Category Controller Base URL
     */
    public static final String BASE_URL = "/todos";

    /**
     * Inject dependencies
     */
    private final ToDoService toDoService;

    /**
     * Constructor
     */
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping(value = {"/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ToDoListDTO getToDos() {
        return new ToDoListDTO(toDoService.getToDos());
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ToDoDTO postToDo(@RequestBody ToDoDTO dto) {
        return toDoService.create(dto);
    }

    @PutMapping(value = {"/"})
    @ResponseStatus(HttpStatus.OK)
    public ToDoDTO putToDo(@RequestBody ToDoDTO dto) {
        return toDoService.update(dto);
    }

    @DeleteMapping(value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteToDo(@PathVariable Long id) {
        toDoService.delete(id);
    }

    @GetMapping(value = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ToDoDTO getToDo(@PathVariable Long id) {
        Optional<ToDoDTO> toDo = toDoService.getToDo(id);
        return toDo.orElseThrow();
    }

}
