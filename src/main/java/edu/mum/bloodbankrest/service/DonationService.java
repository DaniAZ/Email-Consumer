package edu.mum.bloodbankrest.service;

import edu.mum.bloodbankrest.domain.Donation;

import java.util.List;

public interface DonationService {
    public void save(Donation donation);
    public void update(Donation donation);
    public List<Donation> findAll();

    public Donation findOne(Long id);
}
