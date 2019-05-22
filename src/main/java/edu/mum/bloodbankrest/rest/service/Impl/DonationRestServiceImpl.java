package edu.mum.bloodbankrest.rest.service.Impl;

import edu.mum.bloodbankrest.domain.Donation;
import edu.mum.bloodbankrest.domain.Donor;
import edu.mum.bloodbankrest.domain.UserCredentials;
import edu.mum.bloodbankrest.rest.RestHttpHeader;
import edu.mum.bloodbankrest.rest.service.DonationRestService;
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
public class DonationRestServiceImpl implements DonationRestService {
    @Autowired
    RestHttpHeader restHelper;

    String baseUrl = "http://localhost:8080/donations";
    String baseUrlExtended = baseUrl + "/";

    @Override
    public void save(Donation donation) {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity<Donation> httpEntity = new HttpEntity<Donation>(donation, restHelper.getHttpHeaders());
        donation = restTemplate.postForObject(baseUrl, httpEntity, Donation.class);
        return ;
    }

    @Override
    public void update(Donation donation) {

    }

    @Override
    public List<Donation> findAll() {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
        ResponseEntity<Donation[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Donation[].class);
        List<Donation> userList = Arrays.asList(responseEntity.getBody());
        return userList;
    }

    @Override
    public Donation findOne(Long id) {
        return null;
    }
}
