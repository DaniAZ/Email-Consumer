package edu.mum.bloodbankrest.rest.service;


import edu.mum.bloodbankrest.domain.UserCredentials;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserCredentialsRestService {
    public void save(UserCredentials userCredentials);
    public UserCredentials update(UserCredentials userCredentials);
    public List<UserCredentials> findAll();
    public UserCredentials findOne(String userName);
}
