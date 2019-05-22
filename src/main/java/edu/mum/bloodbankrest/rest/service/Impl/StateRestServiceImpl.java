package edu.mum.bloodbankrest.rest.service.Impl;

import edu.mum.bloodbankrest.domain.State;
import edu.mum.bloodbankrest.domain.UserCredentials;
import edu.mum.bloodbankrest.rest.RestHttpHeader;
import edu.mum.bloodbankrest.rest.service.StateRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class StateRestServiceImpl implements StateRestService {
    @Autowired
    RestHttpHeader restHelper;

    String baseUrl = "http://localhost:8080/states";
    String baseUrlExtended = baseUrl + "/";
    @Override
    public List<State> findAll() {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
        ResponseEntity<State[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, State[].class);
        List<State> userList = Arrays.asList(responseEntity.getBody());
        return userList;
    }
}
