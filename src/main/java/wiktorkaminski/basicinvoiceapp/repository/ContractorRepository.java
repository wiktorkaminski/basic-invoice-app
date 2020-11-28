package wiktorkaminski.basicinvoiceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wiktorkaminski.basicinvoiceapp.entity.Contractor;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {

}
