package wiktorkaminski.basicinvoiceapp.entity;

import org.springframework.beans.factory.annotation.Autowired;
import wiktorkaminski.basicinvoiceapp.repository.InvoiceSymbolRepository;

import javax.persistence.*;

@Entity
public class InvoiceSymbol {

    public InvoiceSymbol() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long invoiceNumber;

    @OneToOne
    private User owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}
