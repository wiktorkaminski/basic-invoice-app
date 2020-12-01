package wiktorkaminski.basicinvoiceapp.repository;

import org.springframework.data.repository.CrudRepository;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceSymbol;

public interface InvoiceSymbolRepository extends CrudRepository<InvoiceSymbol, Long> {

    InvoiceSymbol findFirstByOwner(Long ownerId);
}
