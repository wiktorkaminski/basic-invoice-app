package wiktorkaminski.basicinvoiceapp.bir;
import cis.bir.publ._2014._07.datacontract.ObjectFactory;
import cis.bir.publ._2014._07.datacontract.ParametryWyszukiwania;
import org.springframework.stereotype.Service;
import org.tempuri.IUslugaBIRzewnPubl;
import org.tempuri.UslugaBIRzewnPubl;

import javax.xml.bind.JAXBElement;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.AddressingFeature;
import java.util.Arrays;

import static java.util.Collections.singletonMap;

@Service
public class GusConnector {

    private final UslugaBIRzewnPubl SERVICE = new UslugaBIRzewnPubl();
    private final IUslugaBIRzewnPubl PORT;
    private final String API_KEY = "f157ac544a7847ff8a1c";
    private String sessionKey;

    public GusConnector() {
        this.PORT = SERVICE.getE3(new AddressingFeature());
    }

    public String findContractorByNip(String nip) {
        sessionKey = PORT.zaloguj(API_KEY);

        BindingProvider provider = (BindingProvider) PORT;
        provider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, singletonMap("sid", Arrays.asList(sessionKey)));

        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<String> parametryWyszukiwaniaNip = objectFactory.createParametryWyszukiwaniaNip(nip);

        ParametryWyszukiwania parametryWyszukiwania = new ParametryWyszukiwania();
        parametryWyszukiwania.setNip(parametryWyszukiwaniaNip);

        String result = PORT.daneSzukajPodmioty(parametryWyszukiwania);

        PORT.wyloguj(sessionKey);

        return result;
    }

}