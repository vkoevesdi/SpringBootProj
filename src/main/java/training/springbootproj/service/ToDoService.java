package training.springbootproj.service;

import training.springbootproj.entity.ToDo;

import java.util.List;

public interface ToDoService {

    void createToDo(ToDo toDo);

    void updateToDo(ToDo toDo);
    void deleteTodoById(Long id);
    List<ToDo> getAllToDo();
    List<ToDo> getOpenToDo();
    List<ToDo> getClosedToDo();

    Long countOpenToDo();
    Long countClosedToDo();



}
