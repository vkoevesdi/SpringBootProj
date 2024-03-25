package training.springbootproj.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import training.springbootproj.annotation.HasRightToDoCreate;
import training.springbootproj.annotation.HasRightToDoDelete;
import training.springbootproj.annotation.HasRightToDoRead;
import training.springbootproj.annotation.HasRightToDoUpdate;
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
    @HasRightToDoCreate
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ToDo> createToDo(@Valid @RequestBody CreateToDoTDO createToDoTDO) {
        return new ResponseEntity<>(toDoServiceImpl.createToDo(modelMapper.map(createToDoTDO, ToDo.class)),HttpStatus.CREATED);
    }

    @PutMapping()
    @HasRightToDoUpdate
    public ResponseEntity<ToDo> updateToDo(@Valid @RequestBody UpdateToDoTDO updateToDoTDO) {
        return new ResponseEntity<>(toDoServiceImpl.createToDo(modelMapper.map(updateToDoTDO,ToDo.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @HasRightToDoDelete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteToDoById(@PathVariable Long id) {
        this.toDoServiceImpl.deleteTodoById(id);
    }

    @GetMapping("/{id}")
    @HasRightToDoRead
    public ResponseEntity<ToDo> getToDoById(@PathVariable Long id) {
        return new ResponseEntity<>(this.toDoServiceImpl.getToDoById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('TODO_READ_ALL')")
    public ResponseEntity<List<ToDo>> getAllToDo() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("My-custom-Header", "My-custom-value");
        return new ResponseEntity<>(this.toDoServiceImpl.getAllToDo(), responseHeaders, HttpStatus.OK);
    }

    @GetMapping("/completed")
    @PreAuthorize("hasRole('TODO_READ_COMPLETED')")
    public ResponseEntity<List<ToDo>> findAllByCompletedIsTrue() {
        return new ResponseEntity<>(this.toDoServiceImpl.findAllByCompletedIsTrue(), HttpStatus.OK);
    }

    @GetMapping("/open")
    @PreAuthorize("hasRole('TODO_READ_OPEN')")
    public ResponseEntity<List<ToDo>> findAllByCompletedIsFalse() {
        return new ResponseEntity<>(this.toDoServiceImpl.findAllByCompletedIsFalse(),HttpStatus.OK);
    }

    @GetMapping("/completed/count")
    @PreAuthorize("hasRole('TODO_READ_COUNT_COMPLETED')")
    public ResponseEntity<Long> countAllByCompletedIsTrue() {
        return new ResponseEntity<>(this.toDoServiceImpl.countAllByCompletedIsTrue(), HttpStatus.OK);
    }

    @GetMapping("/open/count")
    @PreAuthorize("hasRole('TODO_READ_COUNT_OPEN')")
    public ResponseEntity<Long> countAllByCompletedIsFalse() {
        return new ResponseEntity<>(this.toDoServiceImpl.countAllByCompletedIsFalse(), HttpStatus.OK);
    }

}
