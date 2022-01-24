package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tm.hardwareinventory.model.SoftwareType;

@Repository
public interface SoftwareTypeRepository extends JpaRepository<SoftwareType, Long> {
}
