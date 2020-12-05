package wiktorkaminski.basicinvoiceapp.repository;

import org.springframework.data.repository.CrudRepository;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceContractor;

public interface InvoiceContractorRepository extends CrudRepository<InvoiceContractor, Long> {
}
