package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tm.hardwareinventory.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
