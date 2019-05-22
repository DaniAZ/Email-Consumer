package edu.mum.bloodbankrest.rest.service;


import edu.mum.bloodbankrest.domain.BloodType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BloodTypeRestService {
    public List<BloodType> findAll();
}
