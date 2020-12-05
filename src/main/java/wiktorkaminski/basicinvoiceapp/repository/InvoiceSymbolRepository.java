package wiktorkaminski.basicinvoiceapp.repository;

import org.springframework.data.repository.CrudRepository;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceSymbol;
import wiktorkaminski.basicinvoiceapp.entity.User;

public interface InvoiceSymbolRepository extends CrudRepository<InvoiceSymbol, Long> {

    InvoiceSymbol findFirstByOwner(User user);
}
