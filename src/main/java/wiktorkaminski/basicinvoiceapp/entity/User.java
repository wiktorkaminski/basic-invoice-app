package wiktorkaminski.basicinvoiceapp.entity;

import javax.persistence.*;

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

    @OneToOne
    private Contractor company;

}
