package edu.mum.bloodbankrest.rest.service;


import edu.mum.bloodbankrest.domain.Hospital;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HospitalRestService {
    public void save(Hospital hospital);
    public void update(Hospital hospital);
    public List<Hospital> findAll();

    public Hospital findOne(Long id);
}
