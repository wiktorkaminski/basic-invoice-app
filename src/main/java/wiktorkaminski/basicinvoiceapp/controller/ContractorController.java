package wiktorkaminski.basicinvoiceapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import wiktorkaminski.basicinvoiceapp.bir.GusConnector;
import wiktorkaminski.basicinvoiceapp.bir.GusResponseProcessor;
import wiktorkaminski.basicinvoiceapp.entity.Contractor;
import wiktorkaminski.basicinvoiceapp.entity.User;
import wiktorkaminski.basicinvoiceapp.repository.ContractorRepository;
import wiktorkaminski.basicinvoiceapp.repository.UserRepository;

import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/contractor")
public class ContractorController {

    private final ContractorRepository contractorRepository;
    private final UserRepository userRepository;
    private final GusConnector gusConnector;

    public ContractorController(ContractorRepository contractorRepository, UserRepository userRepository, GusConnector gusConnector) {
        this.contractorRepository = contractorRepository;
        this.userRepository = userRepository;
        this.gusConnector = gusConnector;
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("contractor", new Contractor());
        return "contractor/form";
    }

    @PostMapping("/form")
    public String processForm(Contractor contractor, SessionStatus sessionStatus, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        contractor.setOwner(user);
        contractorRepository.save(contractor);
        sessionStatus.setComplete();
        return "redirect:/contractor/list";
    }

    @GetMapping("/list")
    public String showAllContractors(Model model, SessionStatus sessionStatus, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        List<Contractor> contractors = contractorRepository.getAllByOwner(user);
        model.addAttribute("contractors", contractors);
        sessionStatus.setComplete();
        return "contractor/list";
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

    @GetMapping("/bir/search")
    public String birQueryForm() {
        return "contractor/bir-form";
    }

    @PostMapping("/bir/search")
    public String processBirQuery(Model model, @RequestParam String nip) {

        String gusResponse = gusConnector.findContractorByNip(nip);
        Contractor contractor = GusResponseProcessor.bind(gusResponse);
        model.addAttribute("contractor", contractor);
        return "contractor/form";

    }

}
