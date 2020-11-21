package wiktorkaminski.basicinvoiceapp.entity;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "contractors")
public class Contractor {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String name;

    @Column(length = 16)
    private String shortName;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private String NIP;

    private String REGON;

    private String phone;

    private String email;

    private String website;

}
