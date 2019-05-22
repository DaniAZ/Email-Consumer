package edu.mum.bloodbankrest.dao.impl;

import edu.mum.bloodbankrest.dao.StateDao;
import edu.mum.bloodbankrest.domain.State;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unchecked")
@Repository
public class StateDaoImpl extends GenericDaoImpl<State> implements StateDao {
       StateDaoImpl(){
           super.setDaoType(State.class);
       }
}
