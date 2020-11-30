package wiktorkaminski.basicinvoiceapp.repository;

import org.springframework.data.repository.CrudRepository;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceProduct;

public interface InvoiceProductRepository extends CrudRepository<InvoiceProduct, Long> {
}
