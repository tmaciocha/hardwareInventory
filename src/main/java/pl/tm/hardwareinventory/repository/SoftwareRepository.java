package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.tm.hardwareinventory.model.Hardware;
import pl.tm.hardwareinventory.model.Software;

import java.util.List;

public interface SoftwareRepository extends JpaRepository<Software,Long> {

    @Query(value = "select * from software where name like %?1% or serial_key Like %?1% or version like %?1%", nativeQuery = true)
    List<Software> findAllWhereIsSearch (String search);

   /* @Query(value = "select * from software where software.producer_id like ?1", nativeQuery = true)
    List<Software> findAllByProducerId(long id);*/
}
