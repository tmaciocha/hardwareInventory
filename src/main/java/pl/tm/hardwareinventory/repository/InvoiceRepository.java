package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tm.hardwareinventory.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
