package edu.mum.bloodbankrest.service.impl;


import edu.mum.bloodbankrest.domain.Status;
import edu.mum.bloodbankrest.rest.service.StatusRestService;
import edu.mum.bloodbankrest.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRestService statusRestService;
    @Override
    public List<Status> findAll() {
        return statusRestService.findAll();
    }
}
