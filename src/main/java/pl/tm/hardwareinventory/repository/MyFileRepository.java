package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tm.hardwareinventory.model.MyFile;

public interface MyFileRepository extends JpaRepository<MyFile,Long> {
}
