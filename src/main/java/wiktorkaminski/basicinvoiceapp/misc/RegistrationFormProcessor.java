package wiktorkaminski.basicinvoiceapp.misc;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import wiktorkaminski.basicinvoiceapp.entity.Address;
import wiktorkaminski.basicinvoiceapp.entity.Contractor;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceSymbol;
import wiktorkaminski.basicinvoiceapp.entity.User;
import wiktorkaminski.basicinvoiceapp.repository.AddressRepository;
import wiktorkaminski.basicinvoiceapp.repository.ContractorRepository;
import wiktorkaminski.basicinvoiceapp.repository.InvoiceSymbolRepository;
import wiktorkaminski.basicinvoiceapp.repository.UserRepository;
import wiktorkaminski.basicinvoiceapp.security.RegistrationForm;

@Service
public class RegistrationFormProcessor {

    private final ContractorRepository contractorRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final InvoiceSymbolRepository invoiceSymbolRepository;
    private final PasswordEncoder passwordEncoder;


    public RegistrationFormProcessor(ContractorRepository contractorRepository, AddressRepository addressRepository, UserRepository userRepository, InvoiceSymbolRepository invoiceSymbolRepository, PasswordEncoder passwordEncoder) {
        this.contractorRepository = contractorRepository;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.invoiceSymbolRepository = invoiceSymbolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User prepareUser(RegistrationForm registrationForm) {
        Address address = new Address(
                registrationForm.getCountry(),
                registrationForm.getCity(),
                registrationForm.getStreet(),
                registrationForm.getZipCode(),
                registrationForm.getProperty()
        );
        Address savedAddress = addressRepository.save(address);

        Contractor userCompany = new Contractor(
                registrationForm.getCompanyName(),
                registrationForm.getShortName(),
                savedAddress,
                registrationForm.getNip(),
                registrationForm.getRegon(),
                registrationForm.getPhone(),
                registrationForm.getEmail(),
                registrationForm.getWebsite()
        );
        Contractor savedUserCompany = contractorRepository.save(userCompany);

        User user = new User(
                registrationForm.getFirstName(),
                registrationForm.getLastName(),
                registrationForm.getUsername(),
                passwordEncoder.encode(registrationForm.getPassword()),
                "ROLE_USER",
                true,
                savedUserCompany
        );
        User savedUser = userRepository.save(user);

        savedUserCompany.setOwner(savedUser);
        contractorRepository.save(savedUserCompany);

        InvoiceSymbol newUserSymbol = new InvoiceSymbol();
        newUserSymbol.setOwner(savedUser);
        invoiceSymbolRepository.save(newUserSymbol);

        return savedUser;
    }
}
