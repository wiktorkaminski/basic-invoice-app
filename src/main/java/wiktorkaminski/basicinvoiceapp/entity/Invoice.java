package wiktorkaminski.basicinvoiceapp.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @ManyToOne
    private InvoiceContractor seller;

    @ManyToOne
    private InvoiceContractor buyer;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    private LocalDate saleDate;

    private LocalDate paymentDate;

    @Column(columnDefinition = "TINYINT(1)")
    private int paymentStatus;

    private String paymentMethod;

    private BigDecimal amountPaid;

    @OneToOne
    private InvoiceProductList invoiceProductList;

    private String notes;

    @PrePersist
    public void prePersist() {
        this.createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedOn = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String signature) {
        this.symbol = signature;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public InvoiceContractor getSeller() {
        return seller;
    }

    public void setSeller(InvoiceContractor seller) {
        this.seller = seller;
    }

    public InvoiceContractor getBuyer() {
        return buyer;
    }

    public void setBuyer(InvoiceContractor buyer) {
        this.buyer = buyer;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        this.amountPaid = amountPaid;
    }

    public InvoiceProductList getInvoiceProductList() {
        return invoiceProductList;
    }

    public void setInvoiceProductList(InvoiceProductList invoiceProductList) {
        this.invoiceProductList = invoiceProductList;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
