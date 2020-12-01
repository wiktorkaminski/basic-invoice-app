package wiktorkaminski.basicinvoiceapp.misc;

import wiktorkaminski.basicinvoiceapp.entity.Invoice;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceSymbol;
import wiktorkaminski.basicinvoiceapp.repository.InvoiceSymbolRepository;

import java.time.LocalDate;

public class InvoiceSymbolGenerator {

    private final InvoiceSymbolRepository invoiceSymbolRepository;

    public InvoiceSymbolGenerator(InvoiceSymbolRepository invoiceSymbolRepository) {
        this.invoiceSymbolRepository = invoiceSymbolRepository;
    }

    public String generateSymbol(Invoice invoice) {
        Long ownerId = invoice.getOwner().getId();
        LocalDate saleDate = invoice.getSaleDate();
        String year = String.valueOf(saleDate.getYear());
        String month = String.valueOf(saleDate.getMonth());


        InvoiceSymbol symbol = invoiceSymbolRepository.findFirstByOwner(ownerId);
        Long invoiceNumber = symbol.getInvoiceNumber();

        if (invoiceNumber == null) {
            invoiceNumber = 1L;
        } else {
            invoiceNumber++;
        }

        symbol.setInvoiceNumber(invoiceNumber);
        invoiceSymbolRepository.save(symbol);

        return String.join("/", String.valueOf(invoiceNumber), month, year);
    }
}
