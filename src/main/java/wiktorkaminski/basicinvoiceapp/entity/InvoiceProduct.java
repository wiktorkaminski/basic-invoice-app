package wiktorkaminski.basicinvoiceapp.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class InvoiceProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String units;

    private double quantity;

    private BigDecimal price;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public byte getVatRate() {
        return vatRate;
    }

    public void setVatRate(byte vatRate) {
        this.vatRate = vatRate;
    }
}
