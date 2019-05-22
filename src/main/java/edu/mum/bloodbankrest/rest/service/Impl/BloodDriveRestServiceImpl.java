package edu.mum.bloodbankrest.rest.service.Impl;

import edu.mum.bloodbankrest.domain.BloodDrive;
import edu.mum.bloodbankrest.domain.Donation;
import edu.mum.bloodbankrest.domain.Donor;
import edu.mum.bloodbankrest.domain.UserCredentials;
import edu.mum.bloodbankrest.rest.RestHttpHeader;
import edu.mum.bloodbankrest.rest.service.BloodDriveRestService;
import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class BloodDriveRestServiceImpl implements BloodDriveRestService {
    @Autowired
    RestHttpHeader restHelper;

    String baseUrl = "http://localhost:8080/bloodDrives";
    String baseUrlExtended = baseUrl + "/";
    @Override
    public void save(BloodDrive bloodDrive) {
        System.out.println(bloodDrive);
            RestTemplate restTemplate = restHelper.getRestTemplate();
            HttpEntity<BloodDrive> httpEntity = new HttpEntity<BloodDrive>(bloodDrive, restHelper.getHttpHeaders());
            restTemplate.postForLocation(baseUrl,bloodDrive,BloodDrive.class);

            return;


    }

    @Override
    public void update(BloodDrive bloodDrive) {

    }

    @Override
    public List<BloodDrive> findAll() {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
        ResponseEntity<BloodDrive[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, BloodDrive[].class);
        List<BloodDrive> userList = Arrays.asList(responseEntity.getBody());
        return userList;
    }

    @Override
    public BloodDrive findOne(Long id) {
        return null;
    }
}
