package edu.mum.bloodbankrest.service;


import edu.mum.bloodbankrest.domain.Status;

import java.util.List;

public interface StatusService {
    public List<Status> findAll();
}
