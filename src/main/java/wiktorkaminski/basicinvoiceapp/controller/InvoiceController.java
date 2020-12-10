package wiktorkaminski.basicinvoiceapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import wiktorkaminski.basicinvoiceapp.DTO.ContractorDto;
import wiktorkaminski.basicinvoiceapp.DTO.InvoiceDto;
import wiktorkaminski.basicinvoiceapp.converter.ContractorConverter;
import wiktorkaminski.basicinvoiceapp.entity.*;
import wiktorkaminski.basicinvoiceapp.misc.InvoiceUtils;
import wiktorkaminski.basicinvoiceapp.misc.SymbolGenerator;
import wiktorkaminski.basicinvoiceapp.repository.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    private final Logger logger = LoggerFactory.getLogger(InvoiceController.class);
    private final ContractorRepository contractorRepository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceProductListRepository invoiceProductListRepo;
    private final InvoiceProductRepository invoiceProductRepo;
    private final InvoiceContractorRepository invoiceContractorRepo;
    private final UserRepository userRepository;
    private final SymbolGenerator symbolGenerator;
    private final List<String> units = new ArrayList<>(Arrays.asList("psc", "service", "set"));
    private final List<Byte> vatRate = new ArrayList<>(Arrays.asList(
            Byte.parseByte("0"),
            Byte.parseByte("5"),
            Byte.parseByte("8"),
            Byte.parseByte("23")
    ));


    @Autowired
    public InvoiceController(InvoiceRepository invoiceRepository, ContractorRepository contractorRepository, InvoiceProductListRepository invoiceProductListRepo, InvoiceProductRepository invoiceProductRepo, InvoiceContractorRepository invoiceContractorRepo, UserRepository userRepository, SymbolGenerator symbolGenerator) {
        this.contractorRepository = contractorRepository;
        this.invoiceProductListRepo = invoiceProductListRepo;
        this.invoiceProductRepo = invoiceProductRepo;
        this.invoiceRepository = invoiceRepository;
        this.invoiceContractorRepo = invoiceContractorRepo;
        this.userRepository = userRepository;
        this.symbolGenerator = symbolGenerator;
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
    public String newInvoiceStep2(Model model, @RequestParam Long listId, SessionStatus sessionStatus, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        InvoiceContractor invoiceSeller = ContractorConverter.convertToInvoiceContractor(user.getCompany());
        InvoiceContractor savedInvoiceSeller = invoiceContractorRepo.save(invoiceSeller);

        Invoice newInvoice = new Invoice();
        newInvoice.setSaleDate(LocalDate.now());
        newInvoice.setSeller(savedInvoiceSeller);
        newInvoice.setInvoiceProductList(invoiceProductListRepo.findById(listId).orElseThrow(NoSuchElementException::new));
        model.addAttribute("invoice", newInvoice);
        model.addAttribute("contractors", contractorRepository.getAllByOwner(user));

        sessionStatus.setComplete();
        return "invoice/new-invoice-step-2";
    }

    @PostMapping("/new-invoice-step-3")
    public String newInvoiceStep3(Model model, Invoice invoice, Long buyerId, SessionStatus sessionStatus, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());

        Contractor buyer = contractorRepository.findById(buyerId).orElseThrow(NoSuchElementException::new);
        InvoiceContractor invoiceBuyer = ContractorConverter.convertToInvoiceContractor(buyer);
        invoiceBuyer = invoiceContractorRepo.save(invoiceBuyer);

        invoice.setBuyer(invoiceBuyer);
        invoice.setOwner(user);
        String invoiceSymbol = symbolGenerator.generate(invoice);
        invoice.setSymbol(invoiceSymbol);

        Invoice savedInvoice = invoiceRepository.save(invoice);
        model.addAttribute("invoice", savedInvoice);

        return "/invoice/new-invoice-summary";
    }

    @GetMapping("/list")
    public String invoiceList(Model model, SessionStatus sessionStatus, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        model.addAttribute("invoices", invoiceRepository.findAllByOwner(user));
        sessionStatus.setComplete();
        return "/invoice/list";
    }
}
