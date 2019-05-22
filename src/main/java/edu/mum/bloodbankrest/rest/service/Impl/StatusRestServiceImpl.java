package edu.mum.bloodbankrest.rest.service.Impl;

import edu.mum.bloodbankrest.domain.Status;
import edu.mum.bloodbankrest.rest.RestHttpHeader;
import edu.mum.bloodbankrest.rest.service.StatusRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class StatusRestServiceImpl implements StatusRestService {
    @Autowired
    RestHttpHeader restHelper;

    String baseUrl = "http://localhost:8080/status";
    String baseUrlExtended = baseUrl + "/";
    @Override
    public List<Status> findAll() {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
        ResponseEntity<Status[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Status[].class);
        List<Status> userList = Arrays.asList(responseEntity.getBody());
        return userList;
    }
}
