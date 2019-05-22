package edu.mum.bloodbankrest.rest.service;


import edu.mum.bloodbankrest.domain.Status;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StatusRestService {
    public List<Status> findAll();
}
