package wiktorkaminski.basicinvoiceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wiktorkaminski.basicinvoiceapp.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
