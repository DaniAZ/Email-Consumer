package edu.mum.bloodbankrest.dao.impl;


import edu.mum.bloodbankrest.dao.BloodDriveDao;
import edu.mum.bloodbankrest.domain.BloodDrive;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class BloodDriveDaoImpl extends GenericDaoImpl<BloodDrive> implements BloodDriveDao {
    public BloodDriveDaoImpl() {
        super.setDaoType(BloodDrive.class );
    }
}
