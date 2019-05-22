package edu.mum.bloodbankrest.service;

import edu.mum.bloodbankrest.domain.Hospital;

import java.util.List;

public interface HospitalService {
    public void save(Hospital hospital);
    public void update(Hospital hospital);
    public List<Hospital> findAll();

    public Hospital findOne(Long id);
}
