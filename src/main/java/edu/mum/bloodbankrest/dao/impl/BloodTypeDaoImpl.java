package edu.mum.bloodbankrest.dao.impl;

import edu.mum.bloodbankrest.dao.BloodTypeDao;
import edu.mum.bloodbankrest.domain.BloodType;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class BloodTypeDaoImpl extends GenericDaoImpl<BloodType> implements BloodTypeDao {
    BloodTypeDaoImpl(){
        super.setDaoType(BloodType.class);
    }
}
