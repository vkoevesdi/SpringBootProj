package training.springbootproj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import training.springbootproj.entity.ToDo;

import java.util.Optional;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
}
