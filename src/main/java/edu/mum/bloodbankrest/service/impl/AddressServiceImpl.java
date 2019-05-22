package edu.mum.bloodbankrest.service.impl;


import edu.mum.bloodbankrest.domain.Address;
import edu.mum.bloodbankrest.rest.service.AddressRestService;
import edu.mum.bloodbankrest.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@Service
@Transactional
public class AddressServiceImpl implements AddressService {


    @Autowired
    private AddressRestService addressRestService;

    @Override
    public void save(Address address) {
        addressRestService.save(address);
    }

    @Override
    public void update(Address address) {
        addressRestService.update(address);
    }

    @Override
    public List<Address> findAll() {
        return addressRestService.findAll();
    }

    @Override
    public Address findOne(Long id) {
        return addressRestService.findOne(id);
    }
}
