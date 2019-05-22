package edu.mum.bloodbankrest.rest.service;


import edu.mum.bloodbankrest.domain.BloodDrive;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BloodDriveRestService {
    public void save(BloodDrive bloodDrive);
    public void update(BloodDrive bloodDrive);
    public List<BloodDrive> findAll();

    public BloodDrive findOne(Long id);
}
