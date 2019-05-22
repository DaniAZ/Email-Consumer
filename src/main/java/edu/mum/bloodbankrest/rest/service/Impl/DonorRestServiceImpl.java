package edu.mum.bloodbankrest.rest.service.Impl;

import edu.mum.bloodbankrest.domain.Donor;
import edu.mum.bloodbankrest.domain.UserCredentials;
import edu.mum.bloodbankrest.rest.RestHttpHeader;
import edu.mum.bloodbankrest.rest.service.DonorRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class DonorRestServiceImpl implements DonorRestService {
    @Autowired
    RestHttpHeader restHelper;

    String baseUrl = "http://localhost:8080/donors";
    String baseUrlExtended = baseUrl + "/";
    @Override
    public void save(Donor donor) {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity<Donor> httpEntity = new HttpEntity<Donor>(donor, restHelper.getHttpHeaders());
        donor = restTemplate.postForObject(baseUrl, httpEntity, Donor.class);
        return ;
    }

    @Override
    public void update(Donor donor) {

    }

    @Override
    public List<Donor> findAll() {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
        ResponseEntity<Donor[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Donor[].class);
        List<Donor> userList = Arrays.asList(responseEntity.getBody());
        return userList;
    }

    @Override
    public Donor findOne(Long id) {
        return null;
    }
}
