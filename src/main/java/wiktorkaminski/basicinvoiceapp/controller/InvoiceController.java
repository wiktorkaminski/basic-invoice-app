package wiktorkaminski.basicinvoiceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wiktorkaminski.basicinvoiceapp.DTO.ContractorDto;
import wiktorkaminski.basicinvoiceapp.DTO.InvoiceDto;
import wiktorkaminski.basicinvoiceapp.entity.*;
import wiktorkaminski.basicinvoiceapp.misc.InvoiceUtils;
import wiktorkaminski.basicinvoiceapp.repository.ContractorRepository;
import wiktorkaminski.basicinvoiceapp.repository.InvoiceProductListRepository;
import wiktorkaminski.basicinvoiceapp.repository.InvoiceProductRepository;
import wiktorkaminski.basicinvoiceapp.repository.InvoiceRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    private final ContractorRepository contractorRepository;
    private final InvoiceRepository invoiceRepository;
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
    public InvoiceController(InvoiceRepository invoiceRepository, ContractorRepository contractorRepository, InvoiceProductListRepository invoiceProductListRepo, InvoiceProductRepository invoiceProductRepo) {
        this.contractorRepository = contractorRepository;
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
        Invoice newInvoice = new Invoice();
        newInvoice.setSaleDate(LocalDate.now());
        newInvoice.setSeller(new InvoiceContractor());
        model.addAttribute("invoice", newInvoice);
        model.addAttribute("contractors", contractorRepository.findAll());
        return "invoice/new-invoice-step-2";
    }

    @PostMapping("/new-invoice-step-3")
    public String newInvoiceStep3(Model model, Invoice invoice, Long buyerId) {
        Contractor contractor = contractorRepository.findById(buyerId).orElseThrow(NoSuchElementException::new);
        Invoice savedInvoice = invoiceRepository.save(invoice);

        double grossValue = InvoiceUtils.countTotalGrossValue(savedInvoice);
        double netValue = InvoiceUtils.countTotalNetValue(savedInvoice);
        double amountToPay = grossValue - savedInvoice.getAmountPaid();
        // TODO change set owner

        model.addAttribute("grossValue", grossValue);
        model.addAttribute("netValue", netValue);
        model.addAttribute("amountToPay", amountToPay);
        model.addAttribute("invoice", savedInvoice);

        return "redirect:invoice/list";
    }

    @GetMapping("/list")
    public String invoiceList(Model model) {
        model.addAttribute("invoices", invoiceRepository.findAll());
        return "/invoice/list";
    }
}
