package training.springbootproj.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import training.springbootproj.entity.ToDo;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    List<ToDo> findAllByCompletedIsTrue();

    List<ToDo> findAllByCompletedIsFalse();

    Long countAllByCompletedIsTrue();

    Long countAllByCompletedIsFalse();

    @Query("SELECT COUNT(*) FROM ToDo WHERE completed IS true")
    Long countAllByCompletedIsTrueManual();

    @Query("SELECT COUNT(*) FROM ToDo WHERE completed IS false")
    Long countAllByCompletedIsFalseManual();
}
