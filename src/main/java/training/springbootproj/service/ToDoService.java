package training.springbootproj.service;

import training.springbootproj.entity.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoService {

    void createToDo(ToDo toDo);

    void updateToDo(ToDo toDo);
    void deleteTodoById(Long id);
    Optional<ToDo> getToDoById(Long id);
    List<ToDo> getAllToDo();
    List<ToDo> getOpenToDo();
    List<ToDo> getClosedToDo();

    Long countOpenToDo();
    Long countClosedToDo();



}