package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tm.hardwareinventory.model.User;

import java.util.Optional;

public interface FindRepository extends JpaRepository<User, Long>{

    Optional<User> findFirstByFirstName(String name);

}
