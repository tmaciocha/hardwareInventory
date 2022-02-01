package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tm.hardwareinventory.model.Software;

public interface SoftwareRepository extends JpaRepository<Software,Long> {
}
