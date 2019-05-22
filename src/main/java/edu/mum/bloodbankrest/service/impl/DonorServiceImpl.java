package edu.mum.bloodbankrest.service.impl;


import edu.mum.bloodbankrest.dao.DonorDao;
import edu.mum.bloodbankrest.domain.Donor;
import edu.mum.bloodbankrest.rest.service.DonorRestService;
import edu.mum.bloodbankrest.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DonorServiceImpl implements DonorService {

     @Autowired
     private DonorRestService donorRestService;
     @Autowired
     private DonorDao donorDao;

    @Override
    public void save(Donor donor) {
         donorDao.save(donor);
    }

    @Override
    public void update(Donor donor) {
        donorRestService.update(donor);
    }

    @Override
    public List<Donor> findAll() {
        return donorRestService.findAll();
    }

    @Override
    public Donor findOne(Long id) {
        return donorRestService.findOne(id);
    }
}
