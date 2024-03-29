package training.springbootproj.service;

import training.springbootproj.entity.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoService {

    ToDo createToDo(ToDo toDo);

    ToDo updateToDo(ToDo toDo);

    void deleteTodoById(Long id);

    ToDo getToDoById(Long id);

    List<ToDo> getAllToDo();
}
