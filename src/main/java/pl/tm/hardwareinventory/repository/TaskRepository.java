package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.tm.hardwareinventory.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findAllByOrderByPriorityDesc();

    @Query(value = "select count(*) from tasks where status is false ", nativeQuery = true)
    Integer countActiveTask();
}
