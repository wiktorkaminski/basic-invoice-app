package wiktorkaminski.basicinvoiceapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

}
