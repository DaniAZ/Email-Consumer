package edu.mum.bloodbankrest.dao.impl;

import edu.mum.bloodbankrest.dao.HospitalDao;
import edu.mum.bloodbankrest.domain.Hospital;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class HospitalDaoImpl extends GenericDaoImpl<Hospital> implements HospitalDao {
    public HospitalDaoImpl() {
        super.setDaoType(Hospital.class );
    }
}
