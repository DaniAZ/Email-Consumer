package edu.mum.bloodbankrest.service.impl;


import edu.mum.bloodbankrest.dao.BloodDriveDao;
import edu.mum.bloodbankrest.domain.BloodDrive;
import edu.mum.bloodbankrest.rest.service.BloodDriveRestService;
import edu.mum.bloodbankrest.service.BloodDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class BloodDriveServiceImpl implements BloodDriveService {
    @Autowired
    private BloodDriveRestService bloodDriveRestService;
    @Autowired
    private BloodDriveDao bloodDriveDao;

    @Override
    public void save(BloodDrive bloodDrive) {
      //bloodDriveRestService.save(bloodDrive);
        bloodDriveDao.save(bloodDrive);
    }

    @Override
    public void update(BloodDrive bloodDrive) {
     bloodDriveRestService.save(bloodDrive);
    }

    @Override
    public List<BloodDrive> findAll() {
        return bloodDriveRestService.findAll();
    }

    @Override
    public BloodDrive findOne(Long id) {
        return bloodDriveRestService.findOne(id);
    }
}
