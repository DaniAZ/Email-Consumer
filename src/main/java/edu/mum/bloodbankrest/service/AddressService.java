package edu.mum.bloodbankrest.service;

import edu.mum.bloodbankrest.domain.Address;

import java.util.List;

public interface AddressService {
    public void save(Address address);
    public void update(Address address);
    public List<Address> findAll();

    public Address findOne(Long id);
}
