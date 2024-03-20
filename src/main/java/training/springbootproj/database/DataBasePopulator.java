package training.springbootproj.database;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import training.springbootproj.entity.ToDo;
import training.springbootproj.repository.ToDoRepository;
import training.springbootproj.service.ToDoService;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataBasePopulator implements CommandLineRunner {

    private final ToDoRepository toDoRepository;

    private final ToDoService toDoService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Ich bin der Command Line Runner");

        ToDo toDo1 = new ToDo();
        toDo1.setId(null);
        toDo1.setText("Wäsche waschen");
        toDo1.setCompleted(false);

        ToDo toDo2 = new ToDo(null, "Staubsaugen", false);
        ToDo toDo3 = new ToDo(null, "Müll rausbringen", false);
        ToDo toDo4 = new ToDo(null, "Schrank aufräumen", true);

        toDoRepository.saveAll(Arrays.asList(toDo1, toDo2, toDo3, toDo4));

        //System.out.println(toDoRepository.countAllByCompletedIsTrue());
        //System.out.println(toDoService.countClosedToDo());
    }
}
