package edu.mum.bloodbankrest.service.impl;


import edu.mum.bloodbankrest.dao.HospitalDao;
import edu.mum.bloodbankrest.domain.Hospital;
import edu.mum.bloodbankrest.rest.service.HospitalRestService;
import edu.mum.bloodbankrest.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRestService hospitalRestService;

    @Autowired
    private HospitalDao hospitalDao;

    @Override
    public void save(Hospital hospital) {
         hospitalDao.save(hospital);
    }

    @Override
    public void update(Hospital hospital) {
          hospitalRestService.update(hospital);
    }

    @Override
    public List<Hospital> findAll() {
        List<Hospital> userList=hospitalRestService.findAll();
         return userList;
    }

    @Override
    public Hospital findOne(Long id) {
        return hospitalRestService.findOne(id);
    }
}
