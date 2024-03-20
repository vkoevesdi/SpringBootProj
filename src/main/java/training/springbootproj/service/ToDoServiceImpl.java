package training.springbootproj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import training.springbootproj.entity.ToDo;
import training.springbootproj.repository.ToDoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<ToDo> getToDoById(Long id) {
        return this.toDoRepository.findById(id);
    }

    @Override
    public List<ToDo> getAllToDo() {
        return (List<ToDo>) this.toDoRepository.findAll();
    }

    @Override
    public List<ToDo> getOpenToDo() {
        List<ToDo> openToDo = new ArrayList<>();
        List<ToDo> allToDo = (List<ToDo>) this.toDoRepository.findAll();
        for (ToDo t : allToDo) {
            if (!t.getCompleted())
                openToDo.add(t);
        }
        return openToDo;
    }

    @Override
    public List<ToDo> getClosedToDo() {
        List<ToDo> closedToDo = new ArrayList<>();
        List<ToDo> allToDo = (List<ToDo>) this.toDoRepository.findAll();
        for (ToDo t : allToDo) {
            if (t.getCompleted())
                closedToDo.add(t);
        }
        return closedToDo;
    }

    @Override
    public Long countOpenToDo() {
        Long count = 0L;
        List<ToDo> allToDo = (List<ToDo>) this.toDoRepository.findAll();
        for (ToDo t : allToDo) {
            if (!t.getCompleted())
                count++;
        }
        return count;
    }

    @Override
    public Long countClosedToDo() {
        Long count = 0L;
        List<ToDo> allToDo = (List<ToDo>) this.toDoRepository.findAll();
        for (ToDo t : allToDo) {
            if (t.getCompleted())
                count++;
        }
        return count;
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
