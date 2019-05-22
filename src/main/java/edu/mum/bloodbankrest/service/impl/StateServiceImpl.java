package edu.mum.bloodbankrest.service.impl;



import edu.mum.bloodbankrest.domain.State;
import edu.mum.bloodbankrest.rest.service.StateRestService;
import edu.mum.bloodbankrest.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StateServiceImpl implements StateService {
    @Autowired
    private StateRestService stateRestService;
    @Override
    public List<State> findAll() {
        return stateRestService.findAll();
    }
}
