package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.tm.hardwareinventory.model.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository extends JpaRepository<Hardware,Long> {


    @Query(value = "select * from hardware where name like %?1% or serial_number Like %?1%", nativeQuery = true)
    List<Hardware> findAllWhereIsSearch (String search);

    @Query(value = "select * from hardware where user_id like ?1", nativeQuery = true)
    List<Hardware> findAllByUserId(long id);
}
