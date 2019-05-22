package edu.mum.bloodbankrest.controller;


import edu.mum.bloodbankrest.domain.UserCredentials;
import edu.mum.bloodbankrest.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/userCredentials")
@RestController
public class UserCredentialsController {
    @Autowired
    UserCredentialsService credentialsService;

    @GetMapping
    public List<UserCredentials> findAll( ) {
        return  credentialsService.findAll();

    }



    @RequestMapping("/{id}")
    public UserCredentials findOne(@PathVariable("id") String userName ) {

        UserCredentials validCredentials = credentialsService.findByUserName(userName);

        return  validCredentials;
    }
}
