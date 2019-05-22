package edu.mum.bloodbankrest.rest.service.Impl;


import edu.mum.bloodbankrest.domain.UserCredentials;
import edu.mum.bloodbankrest.rest.RestHttpHeader;
import edu.mum.bloodbankrest.rest.service.UserCredentialsRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class UserCredentialsRestServiceImpl implements UserCredentialsRestService {
    @Autowired
    RestHttpHeader restHelper;

    String baseUrl = "http://localhost:8080/userCredentials";
    String baseUrlExtended = baseUrl + "/";

    public List<UserCredentials> findAll() {

        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
        ResponseEntity<UserCredentials[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, UserCredentials[].class);
        List<UserCredentials> userList = Arrays.asList(responseEntity.getBody());
        return userList;
    }


      @Override
    public UserCredentials findOne(String index) {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
        ResponseEntity<UserCredentials> responseEntity = restTemplate.exchange(baseUrlExtended + index, HttpMethod.GET, httpEntity, UserCredentials.class);
        UserCredentials userCredentials = responseEntity.getBody();
        return userCredentials;
    }

    @Override
    public void save(UserCredentials userCredentials) {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity<UserCredentials> httpEntity = new HttpEntity<UserCredentials>(userCredentials, restHelper.getHttpHeaders());
        userCredentials = restTemplate.postForObject(baseUrl, httpEntity, UserCredentials.class);
        return ;
    }

    @Override
    public UserCredentials update(UserCredentials userCredentials) {
        return null;
    }
}
