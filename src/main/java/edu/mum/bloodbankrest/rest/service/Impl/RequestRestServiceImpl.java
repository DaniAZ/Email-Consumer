package edu.mum.bloodbankrest.rest.service.Impl;

import edu.mum.bloodbankrest.domain.Request;
import edu.mum.bloodbankrest.domain.UserCredentials;
import edu.mum.bloodbankrest.rest.RestHttpHeader;
import edu.mum.bloodbankrest.rest.service.RequestRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RequestRestServiceImpl implements RequestRestService {
    @Autowired
    RestHttpHeader restHelper;

    String baseUrl = "http://localhost:8080/requests";
    String baseUrlExtended = baseUrl + "/";
    @Override
    public void save(Request request) {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity<Request> httpEntity = new HttpEntity<Request>(request, restHelper.getHttpHeaders());
        request = restTemplate.postForObject(baseUrl, httpEntity, Request.class);
        return ;
    }

    @Override
    public void update(Request request) {

    }

    @Override
    public List<Request> findAll() {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
        ResponseEntity<Request[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Request[].class);
        List<Request> userList = Arrays.asList(responseEntity.getBody());
        return userList;
    }

    @Override
    public Request findOne(Long id) {
        return null;
    }
}
