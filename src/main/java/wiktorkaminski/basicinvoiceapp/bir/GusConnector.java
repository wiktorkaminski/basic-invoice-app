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

    private final String API_KEY = "abcde12345abcde12345";
    private String sessionKey;

    public String findContractorByNip(String nip) {
        UslugaBIRzewnPubl service = new UslugaBIRzewnPubl();
        IUslugaBIRzewnPubl port = service.getE3(new AddressingFeature());

        sessionKey = port.zaloguj(API_KEY);

        BindingProvider provider = (BindingProvider) port;
        provider.getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, singletonMap("sid", Arrays.asList(sessionKey)));

        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<String> parametryWyszukiwaniaNip = objectFactory.createParametryWyszukiwaniaNip(nip);

        ParametryWyszukiwania parametryWyszukiwania = new ParametryWyszukiwania();
        parametryWyszukiwania.setNip(parametryWyszukiwaniaNip);

        String result = port.daneSzukaj(parametryWyszukiwania);
        port.wyloguj(sessionKey);

        return result;
    }

}