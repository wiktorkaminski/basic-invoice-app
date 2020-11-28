package wiktorkaminski.basicinvoiceapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import wiktorkaminski.basicinvoiceapp.entity.Contractor;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {

    @Query(value = "SELECT name FROM contractors WHERE id = ?1", nativeQuery = true)
    public String getContractorNameById(Long id);
}
