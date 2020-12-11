package wiktorkaminski.basicinvoiceapp.entity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Positive;

@Entity
public class InvoiceProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String units;

    @Positive
    @Digits(integer = 8, fraction = 3, message = "Max 3 friction digits")
    private double quantity;

    @Positive
    @Digits(integer = 8, fraction = 2, message = "Max 2 friction digits")
    private double price;

    private byte vatRate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte getVatRate() {
        return vatRate;
    }

    public void setVatRate(byte vatRate) {
        this.vatRate = vatRate;
    }
}
