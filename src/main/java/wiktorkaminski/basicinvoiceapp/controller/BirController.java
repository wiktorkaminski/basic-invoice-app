package wiktorkaminski.basicinvoiceapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wiktorkaminski.basicinvoiceapp.bir.GusConnector;

@Controller
@RequestMapping("/contractor/bir")
public class BirController {

    private final GusConnector gusConnector;

    public BirController(GusConnector gusConnector) {
        this.gusConnector = gusConnector;
    }

    @RequestMapping("/search/{nip}")
    @ResponseBody
    public String searchCompany(@PathVariable String nip) {
        return gusConnector.findContractorByNip(nip);
    }
}
