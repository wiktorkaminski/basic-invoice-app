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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSuperUserFlag() {
        return superUserFlag;
    }

    public void setSuperUserFlag(boolean superUserFlag) {
        this.superUserFlag = superUserFlag;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Contractor getCompany() {
        return company;
    }

    public void setCompany(Contractor company) {
        this.company = company;
    }
}
