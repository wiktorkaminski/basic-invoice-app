package wiktorkaminski.basicinvoiceapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class InvoiceProductList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<InvoiceProduct> productList;

}
