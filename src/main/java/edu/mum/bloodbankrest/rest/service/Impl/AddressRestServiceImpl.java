package edu.mum.bloodbankrest.rest.service.Impl;

import edu.mum.bloodbankrest.domain.Address;
import edu.mum.bloodbankrest.domain.Donor;
import edu.mum.bloodbankrest.domain.UserCredentials;
import edu.mum.bloodbankrest.rest.RestHttpHeader;
import edu.mum.bloodbankrest.rest.service.AddressRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Component
public class AddressRestServiceImpl implements AddressRestService {
    @Autowired
    RestHttpHeader restHelper;

    String baseUrl = "http://localhost:8080/addresses";
    String baseUrlExtended = baseUrl + "/";
    @Override
    public void save(Address address) {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity<Address> httpEntity = new HttpEntity<Address>(address, restHelper.getHttpHeaders());
        address = restTemplate.postForObject(baseUrl, httpEntity, Address.class);
        return ;
    }

    @Override
    public void update(Address address) {

    }

    @Override
    public List<Address> findAll() {
        RestTemplate restTemplate = restHelper.getRestTemplate();
        HttpEntity httpEntity = new HttpEntity(restHelper.getHttpHeaders());
        ResponseEntity<Address[]> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, httpEntity, Address[].class);
        List<Address> userList = Arrays.asList(responseEntity.getBody());
        return userList;
    }

    @Override
    public Address findOne(Long id) {
        return null;
    }
}
