package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tm.hardwareinventory.model.HardwareQuality;

import java.util.List;


@Repository
public interface HardwareQualityRepository extends JpaRepository<HardwareQuality, Long> {
    List<HardwareQuality> findAllByOrderByNameAsc();
}
