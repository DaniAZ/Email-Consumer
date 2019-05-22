package edu.mum.bloodbankrest.dao.impl;

import edu.mum.bloodbankrest.dao.RequestDao;
import edu.mum.bloodbankrest.domain.Request;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unchecked")
@Repository
public class RequestDaoImpl extends GenericDaoImpl<Request> implements RequestDao {
    RequestDaoImpl(){
        super.setDaoType(Request.class);
    }
}
