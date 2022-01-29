package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tm.hardwareinventory.model.Hardware;

public interface HardwareRepository extends JpaRepository<Hardware,Long> {
}
