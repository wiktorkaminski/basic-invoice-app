package wiktorkaminski.basicinvoiceapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wiktorkaminski.basicinvoiceapp.DTO.ContractorDTO;
import wiktorkaminski.basicinvoiceapp.DTO.ContractorDtoConverter;
import wiktorkaminski.basicinvoiceapp.entity.Contractor;
import wiktorkaminski.basicinvoiceapp.repository.ContractorRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/update")
    public String updateContractor(Model model, @RequestParam("id") Long id) {
        model.addAttribute("contractorDto", this.prepareContractorDto(id));
        return "contractor/form";
    }

    @PostMapping("/show-details")
    public String showDetailedContractor(Model model, @RequestParam("id") Long id) {
        model.addAttribute("contractorDto", this.prepareContractorDto(id));
        return "contractor/details";
    }

    @PostMapping("/delete")
    public String delete(Model model, @RequestParam("id") Long id) {
        String contractorName = contractorRepository.getContractorNameById(id);
        model.addAttribute("contractorName", contractorName);
        model.addAttribute("id", id);
        return "contractor/delete-confirmation";
    }

    @PostMapping("/delete-confirmed")
    public String proceedDelete(@RequestParam("id") Long id) {
        contractorRepository.deleteById(id);
        return "redirect:/contractor/list";
    }

    private List<ContractorDTO> prepareContractorDtoList() {
        List<ContractorDTO> contractorDtoList = new ArrayList<>();
        List<Contractor> contractorEntityList = contractorRepository.findAll();

        for (Contractor contractorEntity : contractorEntityList) {
            contractorDtoList.add(contractorDtoConverter.entityToDto(contractorEntity));
        }
        return contractorDtoList;
    }

    private ContractorDTO prepareContractorDto(Long id) {
        Optional<Contractor> contractorEntity = contractorRepository.findById(id);
        ContractorDTO contractorDto = contractorDtoConverter.entityToDto(contractorEntity.orElseThrow(EntityNotFoundException::new));
        return contractorDto;
    }
}
