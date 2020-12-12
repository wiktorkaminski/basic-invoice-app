package wiktorkaminski.basicinvoiceapp.bir.data;

import javax.xml.bind.annotation.XmlElement;

public class Property {

    String houseNo;
    String flatNo;

    @XmlElement(name = "NrNieruchomosci")
    public String getHouseNo() {
        return houseNo;
    }

    @XmlElement(name = "NrLokalu")
    public String getFlatNo() {
        return flatNo;
    }

    @Override
    public String toString() {
        return flatNo == null ? houseNo : String.join("/", houseNo, flatNo);
    }
}
