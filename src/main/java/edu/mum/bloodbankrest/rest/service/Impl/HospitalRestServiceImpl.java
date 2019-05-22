package edu.mum.bloodbankrest.rest.service.Impl;

import edu.mum.bloodbankrest.domain.BloodDrive;
import edu.mum.bloodbankrest.domain.Hospital;
import edu.mum.bloodbankrest.domain.UserCredentials;
import edu.mum.bloodbankrest.rest.RestHttpHeader;
import edu.mum.bloodbankrest.rest.service.HospitalRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class HospitalRestServiceImpl implements HospitalRestService {
    @Autowired
    RestHttpHeader restHelper;

    String baseUrl = "http://localhost:8080/hospitals";
    String baseUrlExtended = baseUrl + "/";
    @Override
    public void save(Hospital hospital) {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity<Hospital> httpEntity = new HttpEntity<Hospital>(hospital, restHelper.getHttpHeaders());
        hospital = restTemplate.postForObject(baseUrl, httpEntity, Hospital.class);
        return ;

    }

    @Override
    public void update(Hospital hospital) {

    }

    @Override
    public List<Hospital> findAll() {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
        ResponseEntity<Hospital[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Hospital[].class);
        List<Hospital> userList = Arrays.asList(responseEntity.getBody());
         return userList;


    }

    @Override
    public Hospital findOne(Long id) {
        return null;
    }
}
