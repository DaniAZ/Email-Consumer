package edu.mum.bloodbankrest.dao.impl;


import edu.mum.bloodbankrest.dao.UserCredentialDao;
import edu.mum.bloodbankrest.domain.UserCredentials;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@SuppressWarnings("unchecked")
@Repository
public class UserCredentialDaoImpl extends GenericDaoImpl<UserCredentials> implements UserCredentialDao {
    public UserCredentialDaoImpl() {
        super.setDaoType(UserCredentials.class );
    }

    public UserCredentials findByUserName(String userName) {

        Query query;
        query = entityManager.createQuery("select m from Authentication m  where m.userName =:userName");
        return (UserCredentials) query.setParameter("userName", userName).getSingleResult();

    }
}
