package wiktorkaminski.basicinvoiceapp.DTO;

import wiktorkaminski.basicinvoiceapp.entity.InvoiceBuyer;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceProductList;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceSeller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class InvoiceDto {
    private Long id;

    private String symbol;

    private Long ownerId;

    private ContractorDto seller;

    private ContractorDto buyer;

    private String saleDate;

    private String paymentDate;

    private int paymentStatus;

    private String paymentMethod;

    private BigDecimal amountPaid;

    private InvoiceProductList invoiceProductList;

    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public ContractorDto getSeller() {
        return seller;
    }

    public void setSeller(ContractorDto seller) {
        this.seller = seller;
    }

    public ContractorDto getBuyer() {
        return buyer;
    }

    public void setBuyer(ContractorDto buyer) {
        this.buyer = buyer;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
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