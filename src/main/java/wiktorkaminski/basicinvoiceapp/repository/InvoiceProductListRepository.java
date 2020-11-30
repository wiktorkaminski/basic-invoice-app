package wiktorkaminski.basicinvoiceapp.repository;

import org.springframework.data.repository.CrudRepository;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceProductList;

public interface InvoiceProductListRepository extends CrudRepository<InvoiceProductList, Long> {

}
