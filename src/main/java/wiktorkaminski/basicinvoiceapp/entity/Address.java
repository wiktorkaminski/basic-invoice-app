package wiktorkaminski.basicinvoiceapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    private String city;

    private String street;

    private String zipCode;

    private String property;

    public Address() {
    }

    public Address(Long id, String country, String city, String street, String zipCode, String property) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.property = property;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String flat) {
        this.property = flat;
    }


}
