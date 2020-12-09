package wiktorkaminski.basicinvoiceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wiktorkaminski.basicinvoiceapp.entity.Invoice;
import wiktorkaminski.basicinvoiceapp.entity.User;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    public List<Invoice> findAllByOwner(User user);
}
