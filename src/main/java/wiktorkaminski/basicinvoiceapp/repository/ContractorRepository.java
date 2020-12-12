package wiktorkaminski.basicinvoiceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wiktorkaminski.basicinvoiceapp.entity.Contractor;
import wiktorkaminski.basicinvoiceapp.entity.User;

import java.util.List;

public interface ContractorRepository extends JpaRepository<Contractor, Long> {

    @Query(value = "SELECT name FROM contractors WHERE id = ?1", nativeQuery = true)
    String getContractorNameById(Long id);

    List<Contractor> getAllByOwner(User owner);
}
