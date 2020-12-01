package wiktorkaminski.basicinvoiceapp.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiktorkaminski.basicinvoiceapp.entity.Contractor;
import wiktorkaminski.basicinvoiceapp.entity.Invoice;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceContractor;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceSeller;

import java.time.LocalDate;

@Component
public class InvoiceDtoConverter {

    private final ContractorDtoConverter contractorDtoConverter;

    public InvoiceDtoConverter(ContractorDtoConverter contractorDtoConverter) {
        this.contractorDtoConverter = contractorDtoConverter;
    }

    public Invoice dtoToEntity(InvoiceDto invoiceDto) {
        Invoice invoice = new Invoice();

        invoice.setId(invoiceDto.getId());

        ContractorDto sellerDto = invoiceDto.getSeller();
        InvoiceContractor invoiceSeller = contractorDtoConverter.dtoToInvoiceContractor(sellerDto);
        invoice.setSeller(invoiceSeller);

        ContractorDto buyerDto = invoiceDto.getBuyer();
        InvoiceContractor invoiceBuyer = contractorDtoConverter.dtoToInvoiceContractor(buyerDto);
        invoice.setBuyer(invoiceBuyer);

        invoice.setSaleDate(LocalDate.parse(invoiceDto.getSaleDate()));
        invoice.setPaymentDate(LocalDate.parse(invoiceDto.getPaymentDate()));
        invoice.setAmountPaid(invoiceDto.getAmountPaid());
        invoice.setNotes(invoiceDto.getNotes());

        return invoice;
    }

    public InvoiceDto entityToDto(Invoice invoice) {

    }
}
