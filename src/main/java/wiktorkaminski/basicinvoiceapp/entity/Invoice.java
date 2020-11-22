package wiktorkaminski.basicinvoiceapp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
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
    @JoinColumn(name = "user_id")
    private User owner;

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

    @Column(columnDefinition = "TINYINT(1)")
    private int paymentStatus;

    private String paymentMethod;

    private BigDecimal amountPaid;

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
