package wiktorkaminski.basicinvoiceapp.controller;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wiktorkaminski.basicinvoiceapp.DTO.ContractorDto;
import wiktorkaminski.basicinvoiceapp.DTO.ContractorDtoConverter;
import wiktorkaminski.basicinvoiceapp.DTO.InvoiceDto;
import wiktorkaminski.basicinvoiceapp.DTO.InvoiceDtoConverter;
import wiktorkaminski.basicinvoiceapp.entity.Contractor;
import wiktorkaminski.basicinvoiceapp.entity.Invoice;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceProduct;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceProductList;
import wiktorkaminski.basicinvoiceapp.misc.InvoiceUtils;
import wiktorkaminski.basicinvoiceapp.repository.ContractorRepository;
import wiktorkaminski.basicinvoiceapp.repository.InvoiceProductListRepository;
import wiktorkaminski.basicinvoiceapp.repository.InvoiceProductRepository;
import wiktorkaminski.basicinvoiceapp.repository.InvoiceRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    private final ContractorRepository contractorRepository;
    private final ContractorDtoConverter contractorDtoConverter;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceDtoConverter invoiceDtoConverter;
    private final InvoiceProductListRepository invoiceProductListRepo;
    private final InvoiceProductRepository invoiceProductRepo;
    private final List<String> units = new ArrayList<>(Arrays.asList("psc", "service", "set"));
    private final List<Byte> vatRate = new ArrayList<>(Arrays.asList(
            Byte.parseByte("0"),
            Byte.parseByte("5"),
            Byte.parseByte("8"),
            Byte.parseByte("23")
    ));


    @Autowired
    public InvoiceController(InvoiceRepository invoiceRepository, ContractorRepository contractorRepository, ContractorDtoConverter contractorDtoConverter, InvoiceDtoConverter invoiceDtoConverter, InvoiceProductListRepository invoiceProductListRepo, InvoiceProductRepository invoiceProductRepo) {
        this.contractorRepository = contractorRepository;
        this.contractorDtoConverter = contractorDtoConverter;
        this.invoiceDtoConverter = invoiceDtoConverter;
        this.invoiceProductListRepo = invoiceProductListRepo;
        this.invoiceProductRepo = invoiceProductRepo;
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping("/new-invoice-step-1-1")
    public String newInvoiceStep1_1(Model model, @RequestParam(defaultValue = "-1") Long listId) {
        InvoiceProduct invoiceProduct = new InvoiceProduct();
        model.addAttribute("units", units);
        model.addAttribute("vatRate", vatRate);
        model.addAttribute("invoiceProduct", invoiceProduct);
        model.addAttribute("listId", listId);

        return "invoice/new-invoice-step-1";
    }

    @PostMapping("/new-invoice-step-1-2")
    public String newInvoiceStep1_2(Model model, InvoiceProduct invoiceProduct, @RequestParam Long listId) {
        InvoiceProductList invoiceProductList;
        if (listId == -1) {
            invoiceProductList = new InvoiceProductList();
        } else {
            invoiceProductList = invoiceProductListRepo.findById(listId).get();
        }

        InvoiceProduct savedProduct = invoiceProductRepo.save(invoiceProduct);
        invoiceProductList.getProductList().add(savedProduct);
        InvoiceProductList savedProductList = invoiceProductListRepo.save(invoiceProductList);

        model.addAttribute("productList", savedProductList);
        return "/invoice/new-invoice-step-1-list";
    }

    @PostMapping("/new-invoice-step-2")
    public String newInvoiceStep2(Model model, @RequestParam Long listId) {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setSaleDate(LocalDate.now().toString());
        invoiceDto.setSeller(new ContractorDto());
        model.addAttribute("invoiceDto", invoiceDto);
        model.addAttribute("contractorsDtoList", this.prepareContractorDtoList());
        model.addAttribute("listId", listId);
        return "invoice/new-invoice-step-2";
    }

    @PostMapping("/new-invoice-step-3")
    public String newInvoiceStep3(Model model, @RequestParam Long listId, InvoiceDto invoiceDto) {
        Invoice invoice = invoiceDtoConverter.dtoToEntity(invoiceDto);
        InvoiceProductList invoiceProductList = invoiceProductListRepo.findById(listId).get();
        invoice.setInvoiceProductList(invoiceProductList);
        Invoice savedInvoice = invoiceRepository.save(invoice);

        double grossValue = InvoiceUtils.countTotalGrossValue(savedInvoice);
        double netValue = InvoiceUtils.countTotalNetValue(savedInvoice);
        double amountToPay = grossValue - savedInvoice.getAmountPaid();

        model.addAttribute("grossValue", grossValue);
        model.addAttribute("netValue", netValue);
        model.addAttribute("amountToPay", amountToPay);
        model.addAttribute("invoice")
        //set owner
        return "redirect:invoice/new-invoice-summary";
    }

    @GetMapping("/list")
    public String invoceList(Model model) {
        List<Invoice> invoices = invoiceRepository.findAll();
        model.addAttribute("invoices", invoices);
        return "/invoice/list";
    }

    private List<ContractorDto> prepareContractorDtoList() {
        List<ContractorDto> contractorDtoList = new ArrayList<>();
        List<Contractor> contractorEntityList = contractorRepository.findAll();

        for (Contractor contractorEntity : contractorEntityList) {
            contractorDtoList.add(contractorDtoConverter.entityToDto(contractorEntity));
        }
        return contractorDtoList;
    }
}
