package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tm.hardwareinventory.model.Company;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findAllByOrderByNameAsc();
}
