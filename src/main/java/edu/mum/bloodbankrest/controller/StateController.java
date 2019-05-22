package edu.mum.bloodbankrest.controller;


import edu.mum.bloodbankrest.domain.State;
import edu.mum.bloodbankrest.domain.Status;
import edu.mum.bloodbankrest.service.StateService;
import edu.mum.bloodbankrest.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/states")
@RestController
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping({"","/all"})
    public List<State> getAllStates(Model model) {
        return  (List<State>)stateService.findAll();

    }
}
