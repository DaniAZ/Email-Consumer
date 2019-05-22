package edu.mum.bloodbankrest.dao.impl;

import edu.mum.bloodbankrest.dao.StatusDao;
import edu.mum.bloodbankrest.domain.Status;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unchecked")
@Repository
public class StatusDaoImpl extends GenericDaoImpl<Status> implements StatusDao {
      StatusDaoImpl(){
          super.setDaoType(Status.class);
      }
}
