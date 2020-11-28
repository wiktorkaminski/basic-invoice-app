package wiktorkaminski.basicinvoiceapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wiktorkaminski.basicinvoiceapp.DTO.ContractorDTO;
import wiktorkaminski.basicinvoiceapp.DTO.ContractorDtoConverter;
import wiktorkaminski.basicinvoiceapp.entity.Contractor;
import wiktorkaminski.basicinvoiceapp.repository.ContractorRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/contractor")
public class ContractorController {

    private final ContractorRepository contractorRepository;
    private final ContractorDtoConverter contractorDtoConverter;

    private final Logger logger = LoggerFactory.getLogger(ContractorController.class);

    public ContractorController(ContractorRepository contractorRepository, ContractorDtoConverter contractorDtoConverter) {
        this.contractorRepository = contractorRepository;
        this.contractorDtoConverter = contractorDtoConverter;
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("contractorDto", new ContractorDTO());
        return "contractor/form";
    }

    @PostMapping("/form")
    public String processForm(ContractorDTO contractorDTO) {
        Contractor contractor = contractorDtoConverter.dtoToEntity(contractorDTO);
        contractorRepository.save(contractor);
        return "redirect:/";
    }

    @GetMapping("/list")
    public String showAllContractors(Model model) {
        model.addAttribute("contractors", this.prepareContractorDtoList());
        return "/contractor/list";
    }

    private List<ContractorDTO> prepareContractorDtoList() {
        List<ContractorDTO> contractorDtoList = new ArrayList<>();
        List<Contractor> contractorEntityList = contractorRepository.findAll();

        for (Contractor contractorEntity : contractorEntityList) {
            contractorDtoList.add(contractorDtoConverter.entityToDto(contractorEntity));
        }
        return contractorDtoList;
    }
}
