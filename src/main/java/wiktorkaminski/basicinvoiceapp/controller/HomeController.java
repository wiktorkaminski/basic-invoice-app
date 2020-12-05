package wiktorkaminski.basicinvoiceapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/dashboard")
    public String home() {
        return "home";
    }

}
