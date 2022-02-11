package pl.tm.hardwareinventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.tm.hardwareinventory.model.Invoice;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

    @Query(value = "select * from invoices where number like %?1% or purchase_date like %?1% or filename like %?1% or description like %?1%", nativeQuery = true)
    List<Invoice> findAllByNumber(String numer);
}
