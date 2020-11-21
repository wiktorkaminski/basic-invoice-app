package wiktorkaminski.basicinvoiceapp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String signature;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Contractor seller;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Contractor buyer;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private LocalDate saleDate;

    private LocalDate paymentDate;

    @Column(precision = 1)
    private int paid;

    private String paymentMethod;

    @Column(scale = 2)
    private Double amountPaid;

    @OneToMany
    private Map<Double, Product> invoiceItems;

    private String notes;

    @PrePersist
    public void prePersist() {
        this.createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedOn = LocalDateTime.now();
    }


}
