package wiktorkaminski.basicinvoiceapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wiktorkaminski.basicinvoiceapp.entity.Contractor;
import wiktorkaminski.basicinvoiceapp.repository.ContractorRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/contractor")
public class ContractorController {

    private final ContractorRepository contractorRepository;

    public ContractorController(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("contractor", new Contractor());
        return "contractor/form";
    }

    @PostMapping("/form")
    public String processForm(Contractor contractor) {
        contractorRepository.save(contractor);
        return "redirect:/contractor/list";
    }

    @GetMapping("/list")
    public String showAllContractors(Model model) {
        List<Contractor> contractors = contractorRepository.findAll();
        model.addAttribute("contractors", contractors);
        return "/contractor/list";
    }

    @PostMapping("/update")
    public String updateContractor(Model model, @RequestParam("id") Long id) {
        Contractor contractor = contractorRepository.findById(id).orElseThrow(NoSuchElementException::new);
        model.addAttribute("contractor", contractor);
        return "contractor/form";
    }

    @PostMapping("/show-details")
    public String showDetailedContractor(Model model, @RequestParam("id") Long id) {
        Contractor contractor = contractorRepository.findById(id).orElseThrow(NoSuchElementException::new);
        model.addAttribute("contractor", contractor);
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
}
