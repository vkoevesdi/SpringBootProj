package training.springbootproj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import training.springbootproj.entity.ToDo;
import training.springbootproj.service.ToDoServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoServiceImpl toDoServiceImpl;

    @PostMapping()
    public void createToDo(@RequestBody ToDo toDo){
        this.toDoServiceImpl.createToDo(toDo);
    }
    @PutMapping()
    public void updateToDo(@RequestBody ToDo toDo){
        this.toDoServiceImpl.updateToDo(toDo);
    }

    @DeleteMapping("/{id}")
    public void deleteToDoById(@RequestBody Long id){
        this.toDoServiceImpl.deleteTodoById(id);
    }

    @GetMapping("/all")
    public List<ToDo> getAllToDo() {
        return (List<ToDo>) this.toDoServiceImpl.getAllToDo();
    }

    @GetMapping("/completed")
    public List<ToDo> findAllByCompletedIsTrue(){
        return this.toDoServiceImpl.findAllByCompletedIsTrue();
    }

    @GetMapping("/open")
    public List<ToDo> findAllByCompletedIsFalse() {
        return this.toDoServiceImpl.findAllByCompletedIsFalse();
    }

    @GetMapping("/completed/count")
    public Long countAllByCompletedIsTrue() {
        return this.toDoServiceImpl.countAllByCompletedIsTrue();
    }

    @GetMapping("/open/count")
    public Long countAllByCompletedIsFalse() {
        return this.toDoServiceImpl.countAllByCompletedIsFalse();
    }
}
