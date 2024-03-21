package training.springbootproj.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import training.springbootproj.entity.ToDo;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ToDoRepositoryTest {

    @Autowired
    private ToDoRepository toDoRepository;

    ToDo toDo1 = new ToDo(null, "Wäsche waschen", false);
    ToDo toDo2 = new ToDo(null, "Staubsaugen", false);
    ToDo toDo3 = new ToDo(null, "Müll rausbringen", false);
    ToDo toDo4 = new ToDo(null, "Schrank aufräumen", true);

    final List<ToDo> open = Arrays.asList(toDo1, toDo2, toDo3);
    final List<ToDo> completed = Arrays.asList(toDo4);

    @BeforeEach
    void init() {
        toDoRepository.saveAll(Arrays.asList(toDo1, toDo2, toDo3, toDo4));
    }

    @Test
    void findAllByCompletedIsTrue() {
        List<ToDo> expected = toDoRepository.findAllByCompletedIsTrue();

        assertTrue(expected.containsAll(completed));
        assertEquals(expected.size(), completed.size());
    }

    @Test
    void findAllByCompletedIsFalse() {
        List<ToDo> expected = toDoRepository.findAllByCompletedIsFalse();

        assertTrue(expected.containsAll(open));
        assertEquals(expected.size(), open.size());
    }

    @Test
    void countAllByCompletedIsTrue() {
        Long count = toDoRepository.countAllByCompletedIsTrue();

        assertEquals(completed.size(), count);
    }

    @Test
    void countAllByCompletedIsFalse() {
        Long count = toDoRepository.countAllByCompletedIsFalse();

        assertEquals(open.size(), count);
    }
}