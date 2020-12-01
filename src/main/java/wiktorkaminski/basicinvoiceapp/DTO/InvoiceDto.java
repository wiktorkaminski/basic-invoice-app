package wiktorkaminski.basicinvoiceapp.DTO;

import wiktorkaminski.basicinvoiceapp.entity.InvoiceProductList;

public class InvoiceDto {
    private Long id;

    private String symbol;

    private Long ownerId;

    private ContractorDto seller;

    private ContractorDto buyer;

    private String saleDate;

    private String paymentDate;

    private double amountPaid;

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
}
