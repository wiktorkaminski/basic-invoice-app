package wiktorkaminski.basicinvoiceapp.misc;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import wiktorkaminski.basicinvoiceapp.entity.Invoice;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceSymbol;
import wiktorkaminski.basicinvoiceapp.repository.InvoiceSymbolRepository;

@Service
public class SymbolGenerator {

    private final InvoiceSymbolRepository invoiceSymbolRepo;

    public SymbolGenerator(InvoiceSymbolRepository invoiceSymbolRepo) {
        this.invoiceSymbolRepo = invoiceSymbolRepo;
    }

    public String generate(Invoice invoice) {
        InvoiceSymbol invoiceSymbol = invoiceSymbolRepo.findFirstByOwner(invoice.getOwner());
        long nextInvoiceNumber = invoiceSymbol.getInvoiceNumber() +1 ;
        invoiceSymbol.setInvoiceNumber(nextInvoiceNumber);
        invoiceSymbolRepo.save(invoiceSymbol);
        int month = invoice.getSaleDate().getMonth().getValue();
        int year = invoice.getSaleDate().getYear();
        return String.join("/", String.valueOf(nextInvoiceNumber), String.valueOf(month), String.valueOf(year));
    }
}
