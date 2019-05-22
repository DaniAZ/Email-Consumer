package edu.mum.bloodbankrest.rest.service;

import edu.mum.bloodbankrest.domain.Address;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AddressRestService {
    public void save(Address address);
    public void update(Address address);
    public List<Address> findAll();

    public Address findOne(Long id);
}
