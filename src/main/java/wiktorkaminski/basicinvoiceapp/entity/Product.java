package wiktorkaminski.basicinvoiceapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String units;

    @ManyToOne
    private User owner;

}