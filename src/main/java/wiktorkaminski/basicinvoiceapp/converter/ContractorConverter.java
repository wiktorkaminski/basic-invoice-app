package wiktorkaminski.basicinvoiceapp.converter;

import wiktorkaminski.basicinvoiceapp.entity.Contractor;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceContractor;

public class ContractorConverter {
    public static InvoiceContractor convertToInvoiceContractor(Contractor contractor) {
        InvoiceContractor invoiceContractor = new InvoiceContractor();
        invoiceContractor.setName(contractor.getName());
        invoiceContractor.setShortName(contractor.getShortName());
        invoiceContractor.setCountry(contractor.getAddress().getCountry());
        invoiceContractor.setCity(contractor.getAddress().getCity());
        invoiceContractor.setStreet(contractor.getAddress().getStreet());
        invoiceContractor.setProperty(contractor.getAddress().getProperty());
        invoiceContractor.setZipCode(contractor.getAddress().getZipCode());
        invoiceContractor.setNip(contractor.getNip());
        invoiceContractor.setRegon(contractor.getRegon());
        invoiceContractor.setPhone(contractor.getPhone());
        invoiceContractor.setEmail(contractor.getEmail());

        return invoiceContractor;
    }
}
