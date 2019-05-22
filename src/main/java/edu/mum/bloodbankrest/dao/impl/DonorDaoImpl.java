package edu.mum.bloodbankrest.dao.impl;

import edu.mum.bloodbankrest.dao.DonorDao;
import edu.mum.bloodbankrest.domain.Donor;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unchecked")
@Repository
public class DonorDaoImpl extends GenericDaoImpl<Donor> implements DonorDao {
    DonorDaoImpl(){
        super.setDaoType(Donor.class);
    }
}
