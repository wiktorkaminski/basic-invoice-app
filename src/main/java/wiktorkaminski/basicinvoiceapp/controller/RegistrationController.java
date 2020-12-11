package wiktorkaminski.basicinvoiceapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wiktorkaminski.basicinvoiceapp.entity.User;
import wiktorkaminski.basicinvoiceapp.misc.RegistrationFormProcessor;
import wiktorkaminski.basicinvoiceapp.repository.UserRepository;
import wiktorkaminski.basicinvoiceapp.security.RegistrationForm;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final UserRepository userRepository;
    private final RegistrationFormProcessor registrationFormProcessor;


    public RegistrationController(UserRepository userRepository, RegistrationFormProcessor registrationFormProcessor) {
        this.userRepository = userRepository;
        this.registrationFormProcessor = registrationFormProcessor;
    }

    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "register/registration";
    }

    @PostMapping
    public String processRegistrationForm(Model model, @Valid RegistrationForm form, BindingResult validationResult) {

        if (validationResult.hasErrors()) {
            return "register/registration";
        }

        String username = form.getUsername();
        User user = userRepository.findByUsername(username);
        if (user != null) {
            String msg = String.join(" ",
                    "There is such user registered with email: ",
                    username,
                    ".",
                    "User email has to be unique.");
            model.addAttribute("userExistsErr", msg);
            model.addAttribute("registrationForm", form);
            return "register/registration";
        }

        registrationFormProcessor.prepareUser(form);
        return "redirect:/login";
    }
}
