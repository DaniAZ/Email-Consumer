package edu.mum.bloodbankrest.dao.impl;


import edu.mum.bloodbankrest.dao.AuthorityDao;
import edu.mum.bloodbankrest.domain.Authority;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class AuthorityDaoImpl extends GenericDaoImpl<Authority> implements AuthorityDao {
    public AuthorityDaoImpl() {
        super.setDaoType(Authority.class );
    }
}
