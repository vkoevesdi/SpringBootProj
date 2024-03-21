package training.springbootproj.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import training.springbootproj.entity.ToDo;
import training.springbootproj.repository.ToDoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepository toDoRepository;

    @Override
    public ToDo createToDo(ToDo toDo) {
        return this.toDoRepository.save(toDo);
    }

    @Override
    public ToDo updateToDo(ToDo toDo) {
        if (this.toDoRepository.findById(toDo.getId()).isPresent())
            return this.toDoRepository.save(toDo);
        return null;
    }

    @Override
    public void deleteTodoById(Long id) {
        this.toDoRepository.deleteById(id);
    }

    @Override
    public ToDo getToDoById(Long id) {
        return this.toDoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<ToDo> getAllToDo() {
        return (List<ToDo>) this.toDoRepository.findAll();
    }

    public List<ToDo> findAllByCompletedIsTrue() {
        return toDoRepository.findAllByCompletedIsTrue();
    }

    public List<ToDo> findAllByCompletedIsFalse() {
        return toDoRepository.findAllByCompletedIsFalse();
    }

    public Long countAllByCompletedIsTrue() {
        return toDoRepository.countAllByCompletedIsTrue();
    }

    public Long countAllByCompletedIsFalse() {
        return toDoRepository.countAllByCompletedIsFalse();
    }
}
