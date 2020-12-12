package wiktorkaminski.basicinvoiceapp.bir.data;

import org.springframework.stereotype.Component;
import wiktorkaminski.basicinvoiceapp.entity.Address;
import wiktorkaminski.basicinvoiceapp.entity.Contractor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class RootContractor {

    private Contractor contractor;

    @XmlElement(name = "dane")
    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

}
