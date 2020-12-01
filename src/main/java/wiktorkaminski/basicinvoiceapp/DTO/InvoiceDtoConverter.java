package wiktorkaminski.basicinvoiceapp.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiktorkaminski.basicinvoiceapp.entity.*;
import wiktorkaminski.basicinvoiceapp.repository.UserRepository;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Component
public class InvoiceDtoConverter {

    private final ContractorDtoConverter contractorDtoConverter;
    private final UserRepository userRepository;

    public InvoiceDtoConverter(ContractorDtoConverter contractorDtoConverter, UserRepository userRepository) {
        this.contractorDtoConverter = contractorDtoConverter;
        this.userRepository = userRepository;
    }

    public Invoice dtoToEntity(InvoiceDto invoiceDto) {
        Invoice invoice = new Invoice();

        invoice.setId(invoiceDto.getId());
        invoice.setSymbol(invoiceDto.getSymbol());

        invoice.setOwner(userRepository.findById(invoiceDto.getOwnerId()).orElse(new User()));

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
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setId(invoice.getId());
        invoiceDto.setOwnerId(invoice.getOwner().getId());
        invoiceDto.setSymbol(invoice.getSymbol());
        invoiceDto.setSeller(contractorDtoConverter.invoiceContractorToDto(invoice.getSeller()));
        invoiceDto.setBuyer(contractorDtoConverter.invoiceContractorToDto(invoice.getBuyer()));
        invoiceDto.setSaleDate(invoice.getSaleDate().toString());
        invoiceDto.setPaymentDate(invoice.getPaymentDate().toString());
        invoiceDto.setAmountPaid(invoice.getAmountPaid());
        invoiceDto.setInvoiceProductList(invoice.getInvoiceProductList());
        invoiceDto.setNotes(invoice.getNotes());

        return invoiceDto;
    }
}
