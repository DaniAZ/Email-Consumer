package edu.mum.bloodbankrest.service.impl;


import edu.mum.bloodbankrest.domain.UserCredentials;
import edu.mum.bloodbankrest.rest.service.UserCredentialsRestService;
import edu.mum.bloodbankrest.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserCredentialServiceImpl implements UserCredentialsService {
    @Autowired
    private UserCredentialsRestService userCredentialsRestService;
    private UserCredentials userCredentials  = new UserCredentials();
    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void save( UserCredentials userCredentials) {
        userCredentialsRestService.save(userCredentials);
    }


    public List<UserCredentials> findAll() {
        return (List<UserCredentials>)userCredentialsRestService.findAll();
    }

    public UserCredentials findByUserName(String userName) {
        return userCredentialsRestService.findOne(userName);
    }


    @Override
    public UserCredentials update(UserCredentials userCredentials) {
        return userCredentialsRestService.update(userCredentials);

    }
}
