package com.example.springdocker.bootstrap;

import com.example.springdocker.domain.ToDo;
import com.example.springdocker.model.Status;
import com.example.springdocker.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private ToDoRepository toDoRepository;

    public Bootstrap(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public void run(String... args) {
        addToDos();
    }

    private void addToDos() {

        toDoRepository.deleteAll();

        ToDo fruits = new ToDo();
        fruits.setText("Buy fruits");
        fruits.setStatus(Status.UNREAD);

        ToDo potato = new ToDo();
        potato.setText("Buy potato");
        potato.setStatus(Status.UNREAD);


        toDoRepository.save(fruits);
        toDoRepository.save(potato);
    }

}
