package edu.mum.bloodbankrest.dao;


import edu.mum.bloodbankrest.domain.UserCredentials;

public interface UserCredentialDao extends GenericDao<UserCredentials> {
    public UserCredentials findByUserName(String userName);

}
