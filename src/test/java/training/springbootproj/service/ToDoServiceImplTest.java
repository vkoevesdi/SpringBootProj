package training.springbootproj.service;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import training.springbootproj.entity.ToDo;
import training.springbootproj.repository.ToDoRepository;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ToDoServiceImplTest {
    @Mock
    private ToDoRepository toDoRepository;

    @InjectMocks
    private ToDoServiceImpl toDoServiceImpl;

    @Test
    void createToDo() {
        ToDo notPersistedToDo = new ToDo(null, "Wäsche waschen", null);
        ToDo persistedToDo = new ToDo(1L, "Wäsche waschen", false);

        when(toDoRepository.save(any(ToDo.class))).thenReturn(persistedToDo);

        assertEquals(persistedToDo, toDoServiceImpl.createToDo(notPersistedToDo));
    }

    @Test
    void getToDoById() {
        ToDo toDo1 = new ToDo(null, "Wäsche waschen", false);
        when(toDoRepository.findById(any(Long.class))).thenReturn(Optional.of(toDo1));

        assertEquals(toDo1, toDoServiceImpl.getToDoById(1L));
    }

    @Test
    void getToDoByIdThrowsException() {
        when(toDoRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> toDoServiceImpl.getToDoById(5L));
    }

    @Test
    void updateToDo() {
        ToDo updatedToDo = new ToDo(1L, "Wäsche waschen", true);
        ToDo initialToDo = new ToDo(1L, "Wäsche waschen", true);
        when(toDoRepository.save(any(ToDo.class))).thenReturn(updatedToDo);

        assertEquals(updatedToDo, toDoServiceImpl.updateToDo(initialToDo));         // Service Logik überprüfen
    }

    @Test
    void deleteTodoById() {
        assertDoesNotThrow(() -> toDoServiceImpl.deleteTodoById(1L));
    }

    @Test
    void getAllToDo() {

    }

    @Test
    void findAllByCompletedIsTrue() {

    }

    @Test
    void findAllByCompletedIsFalse() {

    }

    @Test
    void countAllByCompletedIsTrue() {

    }

    @Test
    void countAllByCompletedIsFalse() {

    }
}