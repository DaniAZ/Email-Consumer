package edu.mum.bloodbankrest.service;


import edu.mum.bloodbankrest.domain.Request;

import java.util.List;

public interface RequestService {
    public void save(Request request);
    public void update(Request request);
    public List<Request> findAll();

    public Request findOne(Long id);
}
