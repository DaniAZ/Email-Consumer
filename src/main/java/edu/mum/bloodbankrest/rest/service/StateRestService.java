package edu.mum.bloodbankrest.rest.service;


import edu.mum.bloodbankrest.domain.State;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StateRestService {
    public List<State> findAll();
}
