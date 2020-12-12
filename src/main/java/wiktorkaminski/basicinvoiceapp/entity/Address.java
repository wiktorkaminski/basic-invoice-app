package wiktorkaminski.basicinvoiceapp.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

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

    public Address(String country, String city, String street, String zipCode, String property) {
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

    @XmlElement(name = "Miejscowosc")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement(name = "Ulica")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @XmlElement(name = "KodPocztowy")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }


    public String getFullAddress() {
        return String.join(" ", street, property, zipCode, city);
    }

}
