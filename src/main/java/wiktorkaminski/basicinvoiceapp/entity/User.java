package wiktorkaminski.basicinvoiceapp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    private boolean superUserFlag;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @ManyToOne
    private Contractor company;

}
