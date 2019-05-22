package edu.mum.bloodbankrest.controller;



import edu.mum.bloodbankrest.domain.Status;
import edu.mum.bloodbankrest.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/status")
@RestController
public class StatusController {
    @Autowired
    private StatusService statusService;

    @GetMapping({"","/all"})
    public List<Status> getAllStatus(Model model) {
        return  (List<Status>)statusService.findAll();

    }
}
