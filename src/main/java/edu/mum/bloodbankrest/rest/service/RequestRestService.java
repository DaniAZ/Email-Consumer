package edu.mum.bloodbankrest.rest.service;


import edu.mum.bloodbankrest.domain.Request;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RequestRestService {
    public void save(Request request);
    public void update(Request request);
    public List<Request> findAll();

    public Request findOne(Long id);
}
