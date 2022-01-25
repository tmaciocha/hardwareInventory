package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tm.hardwareinventory.model.HardwareType;

import java.util.List;

public interface HardwareTypeRepository extends JpaRepository<HardwareType, Long> {
    List<HardwareType> findAllByOrderByTypeAsc();
}
