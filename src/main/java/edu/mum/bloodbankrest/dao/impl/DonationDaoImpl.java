package edu.mum.bloodbankrest.dao.impl;

import edu.mum.bloodbankrest.dao.DonationDao;
import edu.mum.bloodbankrest.domain.Donation;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class DonationDaoImpl extends GenericDaoImpl<Donation> implements DonationDao {
    public DonationDaoImpl() {
        super.setDaoType(Donation.class);
    }
}
