package edu.mum.bloodbankrest.service;

import edu.mum.bloodbankrest.domain.Donor;

import java.util.List;

public interface DonorService {
    public void save(Donor donor);
    public void update(Donor donor);
    public List<Donor> findAll();

    public Donor findOne(Long id);
}
