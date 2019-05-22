package edu.mum.bloodbankrest.service;

import edu.mum.bloodbankrest.domain.UserCredentials;

import java.util.List;

public interface UserCredentialsService {
    public void save(UserCredentials userCredentials);
    public UserCredentials update(UserCredentials userCredentials);
    public List<UserCredentials> findAll();
    public UserCredentials findByUserName(String userName);
}
