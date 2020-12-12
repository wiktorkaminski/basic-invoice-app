package wiktorkaminski.basicinvoiceapp.bir.data;

import wiktorkaminski.basicinvoiceapp.entity.Address;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "root")
public class RootAddress {

    private Address address;

    @XmlElement(name = "dane")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
