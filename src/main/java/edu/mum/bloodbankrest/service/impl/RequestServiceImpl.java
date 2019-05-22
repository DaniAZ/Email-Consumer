package edu.mum.bloodbankrest.service.impl;



import edu.mum.bloodbankrest.dao.RequestDao;
import edu.mum.bloodbankrest.domain.Request;
import edu.mum.bloodbankrest.rest.service.RequestRestService;
import edu.mum.bloodbankrest.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRestService requestRestService;
    @Autowired
    private RequestDao requestDao;
    @Override
    public void save(Request request) {
        requestDao.save(request);
    }

    @Override
    public void update(Request request) {
         requestRestService.save(request);
    }

    @Override
    public List<Request> findAll() {
        return requestRestService.findAll();
    }

    @Override
    public Request findOne(Long id) {
        return requestRestService.findOne(id);
    }
}
