package com.example.springdocker.service;

import com.example.springdocker.domain.ToDo;
import com.example.springdocker.mapper.ToDoMapper;
import com.example.springdocker.model.ToDoDTO;
import com.example.springdocker.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Category service implementation class
 */
@Service
public class ToDoServiceImpl implements ToDoService {

    /**
     * Injecting dependencies
     */
    private final ToDoMapper toDoMapper;
    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoServiceImpl(ToDoMapper toDoMapper, ToDoRepository toDoRepository) {
        this.toDoMapper = toDoMapper;
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDoDTO> getToDos() {
        return toDoRepository.findAll()
                .stream()
                .map(toDoMapper::makeToDoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ToDoDTO> getToDo(Long id) {
        Optional<ToDo> rez = toDoRepository.findById(id);
        return rez.map(toDoMapper::makeToDoDTO);
    }

    @Override
    public ToDoDTO create(ToDoDTO dto) {
        ToDo toDo = toDoMapper.makeToDoEntity(dto);
        ToDo rez = toDoRepository.save(toDo);
        return toDoMapper.makeToDoDTO(rez);
    }

    @Override
    public ToDoDTO update(ToDoDTO dto) {
        ToDo toDo = toDoMapper.makeToDoEntity(dto);
        toDoRepository.getReferenceById(toDo.getId());//check if entity exists
        ToDo rez = toDoRepository.save(toDo);
        return toDoMapper.makeToDoDTO(rez);
    }

    @Override
    public void delete(Long id) {
        toDoRepository.deleteById(id);
    }
}
