package wiktorkaminski.basicinvoiceapp.bir;

import org.springframework.stereotype.Service;
import wiktorkaminski.basicinvoiceapp.bir.data.Root;
import wiktorkaminski.basicinvoiceapp.bir.data.RootAddress;
import wiktorkaminski.basicinvoiceapp.bir.data.RootContractor;
import wiktorkaminski.basicinvoiceapp.bir.data.RootProperty;
import wiktorkaminski.basicinvoiceapp.entity.Address;
import wiktorkaminski.basicinvoiceapp.entity.Contractor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringReader;

@Service
public class GusResponseProcessor {

    public static Contractor bind(String gusResponse) {

        try {

            JAXBContext contractorContext = JAXBContext.newInstance(RootContractor.class);
            JAXBContext addressContext = JAXBContext.newInstance(RootAddress.class);
            JAXBContext propertyContext = JAXBContext.newInstance(RootProperty.class);

            RootContractor contractorPart = (RootContractor) contractorContext.createUnmarshaller().unmarshal(new StringReader(gusResponse));
            Contractor contractor = contractorPart.getContractor();
            RootAddress addressPart = (RootAddress) addressContext.createUnmarshaller().unmarshal(new StringReader(gusResponse));
            Address address = addressPart.getAddress();
            RootProperty propertyPart = (RootProperty) propertyContext.createUnmarshaller().unmarshal(new StringReader(gusResponse));
            String property = propertyPart.getProperty().toString();
            address.setProperty(property);
            contractor.setAddress(address);
            return contractor;

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }
}
