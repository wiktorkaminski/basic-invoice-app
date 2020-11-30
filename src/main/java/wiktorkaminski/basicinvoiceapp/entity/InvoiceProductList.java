package wiktorkaminski.basicinvoiceapp.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class InvoiceProductList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<InvoiceProduct> productList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<InvoiceProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<InvoiceProduct> productList) {
        this.productList = productList;
    }
}
