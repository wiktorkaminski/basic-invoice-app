package wiktorkaminski.basicinvoiceapp.bir.model;

import org.hibernate.validator.constraints.pl.NIP;
import org.springframework.stereotype.Component;

@Component
public class Nip {

    @NIP
    private String nip;

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}
