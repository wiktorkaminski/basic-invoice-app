package wiktorkaminski.basicinvoiceapp.bir.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class RootProperty {

    private Property property;

    @XmlElement(name = "dane")
    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
