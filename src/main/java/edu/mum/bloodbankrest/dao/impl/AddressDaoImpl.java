package edu.mum.bloodbankrest.dao.impl;

import edu.mum.bloodbankrest.dao.AddressDao;
import edu.mum.bloodbankrest.domain.Address;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unchecked")
@Repository
public class AddressDaoImpl extends GenericDaoImpl<Address> implements AddressDao {

    public AddressDaoImpl() {
        super.setDaoType(Address.class );
    }

}
