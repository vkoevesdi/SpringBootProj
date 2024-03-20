package training.springbootproj.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import training.springbootproj.dto.CreateToDoTDO;
import training.springbootproj.dto.UpdateToDoTDO;
import training.springbootproj.entity.ToDo;
import training.springbootproj.service.ToDoServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoServiceImpl toDoServiceImpl;
    private final ModelMapper modelMapper;

    @PostMapping()
    public ToDo createToDo(@Valid @RequestBody CreateToDoTDO createToDoTDO) {
        return toDoServiceImpl.createToDo(modelMapper.map(createToDoTDO, ToDo.class));
    }

    @PutMapping()
    public ToDo updateToDo(@Valid @RequestBody UpdateToDoTDO updateToDoTDO) {
        return toDoServiceImpl.createToDo(modelMapper.map(updateToDoTDO,ToDo.class));
    }

    @DeleteMapping("/{id}")
    public void deleteToDoById(@PathVariable Long id) {
        this.toDoServiceImpl.deleteTodoById(id);
    }

    @GetMapping("/{id}")
    public Optional<ToDo> getToDoById(@PathVariable Long id) {
        return this.toDoServiceImpl.getToDoById(id);
    }

    @GetMapping("/all")
    public List<ToDo> getAllToDo() {
        return (List<ToDo>) this.toDoServiceImpl.getAllToDo();
    }

    @GetMapping("/completed")
    public List<ToDo> findAllByCompletedIsTrue() {
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
