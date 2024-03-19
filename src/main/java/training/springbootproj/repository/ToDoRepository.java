package training.springbootproj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import training.springbootproj.entity.ToDo;

import java.util.Optional;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    @Override
    <S extends ToDo> S save(S entity);

    @Override
    <S extends ToDo> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<ToDo> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    Iterable<ToDo> findAll();

    @Override
    Iterable<ToDo> findAllById(Iterable<Long> longs);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(ToDo entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends ToDo> entities);

    @Override
    void deleteAll();
}
