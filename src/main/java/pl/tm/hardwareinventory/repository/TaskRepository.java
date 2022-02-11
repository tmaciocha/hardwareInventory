package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.tm.hardwareinventory.model.Hardware;
import pl.tm.hardwareinventory.model.Software;
import pl.tm.hardwareinventory.model.Task;
import pl.tm.hardwareinventory.model.User;

import javax.validation.constraints.NotBlank;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findAllByOrderByPriorityDesc();

    @Query(value = "select count(*) from tasks where status is false ", nativeQuery = true)
    Integer countActiveTask();

    List<Task> findAllByTitle(String title);

    @Query(value = "select * from tasks where title like %?1% or description Like %?1%", nativeQuery = true)
    List<Task> findAllByTitleOOrderByDescription(String title);

   // List<Task> findAllByTitleOrDescriptionOrHardwareOrSoftwareOrUser(String string);
}
