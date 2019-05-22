package edu.mum.bloodbankrest.rest.service;


import edu.mum.bloodbankrest.domain.Donation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DonationRestService {
    public void save(Donation donation);
    public void update(Donation donation);
    public List<Donation> findAll();

    public Donation findOne(Long id);
}
