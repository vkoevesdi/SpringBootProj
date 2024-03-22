package training.springbootproj.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.springbootproj.dto.CreateToDoTDO;
import training.springbootproj.dto.UpdateToDoTDO;
import training.springbootproj.entity.ToDo;
import training.springbootproj.service.ToDoServiceImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoServiceImpl toDoServiceImpl;
    private final ModelMapper modelMapper;

    @PostMapping()
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ToDo> createToDo(@Valid @RequestBody CreateToDoTDO createToDoTDO) {
        return new ResponseEntity<>(toDoServiceImpl.createToDo(modelMapper.map(createToDoTDO, ToDo.class)),HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<ToDo> updateToDo(@Valid @RequestBody UpdateToDoTDO updateToDoTDO) {
        return new ResponseEntity<>(toDoServiceImpl.createToDo(modelMapper.map(updateToDoTDO,ToDo.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteToDoById(@PathVariable Long id) {
        this.toDoServiceImpl.deleteTodoById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id) {
        return new ResponseEntity<>(this.toDoServiceImpl.getToDoById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ToDo>> getAllToDo() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("My-custom-Header", "My-custom-value");
        return new ResponseEntity<>(this.toDoServiceImpl.getAllToDo(), responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/completed")
    public ResponseEntity<List<ToDo>> findAllByCompletedIsTrue() {
        return new ResponseEntity<>(this.toDoServiceImpl.findAllByCompletedIsTrue(), HttpStatus.OK);
    }

    @GetMapping("/open")
    public ResponseEntity<List<ToDo>> findAllByCompletedIsFalse() {
        return new ResponseEntity<>(this.toDoServiceImpl.findAllByCompletedIsFalse(),HttpStatus.OK);
    }

    @GetMapping("/completed/count")
    public ResponseEntity<Long> countAllByCompletedIsTrue() {
        return new ResponseEntity<>(this.toDoServiceImpl.countAllByCompletedIsTrue(), HttpStatus.OK);
    }

    @GetMapping("/open/count")
    public ResponseEntity<Long> countAllByCompletedIsFalse() {
        return new ResponseEntity<>(this.toDoServiceImpl.countAllByCompletedIsFalse(), HttpStatus.OK);
    }

}
