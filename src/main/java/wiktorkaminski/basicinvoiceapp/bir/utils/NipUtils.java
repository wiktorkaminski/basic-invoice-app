package wiktorkaminski.basicinvoiceapp.bir.utils;

import wiktorkaminski.basicinvoiceapp.bir.model.Nip;

public class NipUtils {
    public static void unify(Nip nip) {
        String s = nip.getNip();
        s = s.trim();
        s = s.replaceAll("[^0-9]", "");
        nip.setNip(s);
    }
}
