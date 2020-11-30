package wiktorkaminski.basicinvoiceapp.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wiktorkaminski.basicinvoiceapp.entity.Address;
import wiktorkaminski.basicinvoiceapp.entity.Contractor;
import wiktorkaminski.basicinvoiceapp.entity.InvoiceContractor;
import wiktorkaminski.basicinvoiceapp.repository.AddressRepository;

import java.util.Optional;

@Component
public class ContractorDtoConverter {

    private final AddressRepository addressRepository;

    @Autowired
    public ContractorDtoConverter(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Contractor dtoToEntity(ContractorDto contractorDTO) {
        Contractor contractor = new Contractor();

        contractor.setId(contractorDTO.getId());
        contractor.setName(contractorDTO.getName());
        contractor.setShortName(contractorDTO.getShortName());
        contractor.setNip(contractorDTO.getNip());
        contractor.setRegon(contractorDTO.getRegon());
        contractor.setPhone(contractorDTO.getPhone());
        contractor.setEmail(contractorDTO.getEmail());
        contractor.setWebsite(contractorDTO.getWebsite());

        Address address = new Address(
                contractorDTO.getAddressId(),
                contractorDTO.getCountry(),
                contractorDTO.getCity(),
                contractorDTO.getStreet(),
                contractorDTO.getZipCode(),
                contractorDTO.getProperty()
        );

        contractor.setAddress(address);

        return contractor;
    }

    public ContractorDto entityToDto(Contractor contractor) {
        ContractorDto contractorDTO = new ContractorDto();
        Optional<Address> tempAddress = addressRepository.findById(contractor.getAddress().getId());
        Address address;
        if (tempAddress.isPresent()) {
            address = tempAddress.get();
        } else {
            address = new Address();
        }

        contractorDTO.setId(contractor.getId());
        contractorDTO.setName(contractor.getName());
        contractorDTO.setShortName(contractor.getShortName());

        contractorDTO.setAddressId(address.getId());
        contractorDTO.setCountry(address.getCountry());
        contractorDTO.setCity(address.getCity());
        contractorDTO.setStreet(address.getStreet());
        contractorDTO.setProperty(address.getProperty());
        contractorDTO.setZipCode(address.getZipCode());

        contractorDTO.setNip(contractor.getNip());
        contractorDTO.setRegon(contractor.getRegon());
        contractorDTO.setPhone(contractor.getPhone());
        contractorDTO.setEmail(contractor.getEmail());
        contractorDTO.setWebsite(contractor.getWebsite());

        return contractorDTO;
    }

    public InvoiceContractor dtoToInvoiceContractor(ContractorDto contractorDto) {
        InvoiceContractor invoiceContractor = new InvoiceContractor();
        invoiceContractor.setId(contractorDto.getId());
        invoiceContractor.setName(contractorDto.getName());

        StringBuilder addressSb = new StringBuilder();
        addressSb.append(contractorDto.getStreet()).append(" ")
                .append(contractorDto.getProperty()).append(" \n")
                .append(contractorDto.getZipCode()).append(" ")
                .append(contractorDto.getCity());

        invoiceContractor.setAddress(addressSb.toString());
        invoiceContractor.setNIP(contractorDto.getNip());
        invoiceContractor.setREGON(contractorDto.getRegon());
        invoiceContractor.setEmail(contractorDto.getEmail());
        invoiceContractor.setPhone(contractorDto.getPhone());

        return invoiceContractor;
    }

}
