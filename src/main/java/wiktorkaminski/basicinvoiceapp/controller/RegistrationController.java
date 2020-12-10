package wiktorkaminski.basicinvoiceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wiktorkaminski.basicinvoiceapp.entity.User;
import wiktorkaminski.basicinvoiceapp.misc.RegistrationFormProcessor;
import wiktorkaminski.basicinvoiceapp.repository.UserRepository;
import wiktorkaminski.basicinvoiceapp.security.RegistrationForm;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegistrationFormProcessor registrationFormProcessor;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder, RegistrationFormProcessor registrationFormProcessor) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.registrationFormProcessor = registrationFormProcessor;
    }

    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "register/registration";
    }

    @PostMapping
    public String processRegistrationForm(Model model, RegistrationForm form) {

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
