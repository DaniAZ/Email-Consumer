package edu.mum.bloodbankrest.service.impl;



import edu.mum.bloodbankrest.domain.BloodType;
import edu.mum.bloodbankrest.rest.service.BloodTypeRestService;
import edu.mum.bloodbankrest.service.BloodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BloodTypeServiceImpl implements BloodTypeService {

    @Autowired
    private BloodTypeRestService bloodTypeRestService;
    @Override
    public List<BloodType> findAll() {
        return bloodTypeRestService.findAll();
    }
}
