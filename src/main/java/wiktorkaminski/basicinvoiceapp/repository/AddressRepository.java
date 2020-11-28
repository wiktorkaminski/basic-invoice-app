package wiktorkaminski.basicinvoiceapp.repository;

import org.springframework.data.repository.CrudRepository;
import wiktorkaminski.basicinvoiceapp.entity.Address;

public interface AddressRepository extends CrudRepository <Address, Long> {
}
