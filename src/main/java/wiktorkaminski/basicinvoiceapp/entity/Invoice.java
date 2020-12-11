package wiktorkaminski.basicinvoiceapp.entity;

import wiktorkaminski.basicinvoiceapp.misc.InvoiceUtils;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private InvoiceContractor seller;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private InvoiceContractor buyer;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

    @NotNull
    @PastOrPresent
    private LocalDate saleDate;

    @NotNull
    @FutureOrPresent
    private LocalDate paymentDate;

    @PositiveOrZero
    @Digits(integer = 8, fraction = 2, message = "Max 2 friction digits")
    private double amountPaid;

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

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
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

    public double getGrossValue() {
        if (invoiceProductList == null || invoiceProductList.getProductList().isEmpty()) {
            return 0.0;

        }
        return InvoiceUtils.countTotalGrossValue(this);
    }

    public double getNetValue() {
        if (invoiceProductList == null || invoiceProductList.getProductList().isEmpty()) {
            return 0.0;

        }
        return InvoiceUtils.countTotalNetValue(this);
    }

    public double getAmountToPay() {
        return (getGrossValue() - amountPaid);
    }

}
