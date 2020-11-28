package wiktorkaminski.basicinvoiceapp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean superUserFlag;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @ManyToOne
    private Contractor company;

}
