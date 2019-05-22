package edu.mum.bloodbankrest.service;

import edu.mum.bloodbankrest.domain.BloodDrive;
import edu.mum.bloodbankrest.domain.Donor;

import java.util.List;

public interface BloodDriveService {

    public void save(BloodDrive bloodDrive);
    public void update(BloodDrive bloodDrive);
    public List<BloodDrive> findAll();

    public BloodDrive findOne(Long id);
}
