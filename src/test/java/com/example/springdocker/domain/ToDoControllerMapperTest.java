package com.example.springdocker.domain;

import com.example.springdocker.mapper.ToDoMapper;
import com.example.springdocker.mapper.ToDoMapperImpl;
import com.example.springdocker.model.Status;
import com.example.springdocker.model.ToDoDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToDoControllerMapperTest {

    private static final String DRIED = "Dried";
    private static final String FRUITS = "Fruits";
    private static final long L1 = 1L;
    private ToDoMapper toDoMapper;

    @Before
    public void init() {
        toDoMapper = new ToDoMapperImpl();
    }

    @Test
    public void categoryToCategoryDTO() {

        // Given
        ToDo toDo = new ToDo();
        toDo.setText(FRUITS);
        toDo.setId(L1);
        toDo.setStatus(Status.UNREAD);

        // When
        ToDoDTO categoryDTO = toDoMapper.makeToDoDTO(toDo);

        // Then
        assertEquals(categoryDTO.getText(), FRUITS);

    }

    @Test
    public void categoryDTOToCategory() {

        // Given
        ToDoDTO categoryDTO = new ToDoDTO();
        categoryDTO.setText(DRIED);
        categoryDTO.setStatus(Status.READ);

        // When
        ToDo toDo = toDoMapper.makeToDoEntity(categoryDTO);

        // Then
        assertEquals(toDo.getText(), DRIED);
        assertEquals(toDo.getStatus(), Status.READ);

    }
}