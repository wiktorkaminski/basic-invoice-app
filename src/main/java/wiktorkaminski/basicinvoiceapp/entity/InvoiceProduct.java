package wiktorkaminski.basicinvoiceapp.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class InvoiceProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private double quantity;

    private BigDecimal price;

    private byte vatRate;

}
