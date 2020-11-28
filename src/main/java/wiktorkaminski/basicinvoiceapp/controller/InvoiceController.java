package wiktorkaminski.basicinvoiceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wiktorkaminski.basicinvoiceapp.DTO.ContractorDto;
import wiktorkaminski.basicinvoiceapp.DTO.ContractorDtoConverter;
import wiktorkaminski.basicinvoiceapp.DTO.InvoiceDto;
import wiktorkaminski.basicinvoiceapp.entity.Contractor;
import wiktorkaminski.basicinvoiceapp.repository.ContractorRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    private final ContractorRepository contractorRepository;
    private final ContractorDtoConverter contractorDtoConverter;

    @Autowired
    public InvoiceController(ContractorRepository contractorRepository, ContractorDtoConverter contractorDtoConverter) {
        this.contractorRepository = contractorRepository;
        this.contractorDtoConverter = contractorDtoConverter;
    }

    @GetMapping("/new")
    public String newInvoice(Model model) {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setSeller(new ContractorDto());
        model.addAttribute("invoiceDto", invoiceDto);
        model.addAttribute("contractorsDtoList", this.prepareContractorDtoList());

        return "invoice/new-invoice-step-1";
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
