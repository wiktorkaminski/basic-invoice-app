package wiktorkaminski.basicinvoiceapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "contractors")
public class Contractor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 16)
    private String shortName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE} )
    @JoinColumn(name = "address_id")
    private Address address;

    private String nip;

    private String regon;

    private String phone;

    private String email;

    private String website;

    @ManyToOne
    private User owner;


    public Contractor() {
    }

    public Contractor(String name, String shortName, Address address, String nip, String regon, String phone, String email, String website) {
        this.name = name;
        this.shortName = shortName;
        this.address = address;
        this.nip = nip;
        this.regon = regon;
        this.phone = phone;
        this.email = email;
        this.website = website;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getLabel() {
        return String.join(" ", shortName, name, address.getCity(), nip);
    }



}
