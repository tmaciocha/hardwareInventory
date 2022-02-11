package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.tm.hardwareinventory.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    Optional<User> findFirstByUsername(String username);

    @Query(value = "select count(*) from users where active_user is true and (end_of_contract between now() and  (now()+INTERVAL 3 MONTH));", nativeQuery = true)
    Integer activeUserNumberWhereContractEndInThreeMonth();

    @Query(value = "select count(*) from users where active_user is true and end_of_contract <= now()", nativeQuery = true)
    Integer usersWhichContractHasEnded();

/*    @Query(value = "select count(*) from users where end_of_contract <= now()  and active_user is true", nativeQuery = true)
    Integer activeUsersNumberWhichContractIsFinished();*/





}
