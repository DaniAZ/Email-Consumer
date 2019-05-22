package edu.mum.bloodbankrest.rest.service.Impl;

import edu.mum.bloodbankrest.domain.BloodType;
import edu.mum.bloodbankrest.domain.UserCredentials;
import edu.mum.bloodbankrest.rest.RestHttpHeader;
import edu.mum.bloodbankrest.rest.service.BloodTypeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class BloodTypeRestServiceImpl implements BloodTypeRestService {
    @Autowired
    RestHttpHeader restHelper;

    String baseUrl = "http://localhost:8080/bloodTypes";
    String baseUrlExtended = baseUrl + "/";
    @Override
    public List<BloodType> findAll() {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
        ResponseEntity<BloodType[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, BloodType[].class);
        List<BloodType> userList = Arrays.asList(responseEntity.getBody());
        return userList;
    }
}
