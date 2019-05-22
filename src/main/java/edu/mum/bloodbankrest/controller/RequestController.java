package edu.mum.bloodbankrest.controller;

import edu.mum.bloodbankrest.domain.BloodDrive;
import edu.mum.bloodbankrest.domain.Hospital;
import edu.mum.bloodbankrest.domain.Request;
import edu.mum.bloodbankrest.service.BloodTypeService;
import edu.mum.bloodbankrest.service.RequestService;
import edu.mum.bloodbankrest.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private BloodTypeService bloodTypeService;
    @Autowired
    private StatusService statusService;
    @GetMapping({"","/all"})
    public List<Request> getAllRequest(Model model) {
        return  (List<Request>)requestService.findAll();

    }

    @GetMapping("/{id}")
    public Request getRequestById( @PathVariable("id") Long hospitalId) {

        return requestService.findOne(hospitalId);
    }

    @GetMapping(value = "/add")
    public String getAddNewRequestForm(@ModelAttribute("newRequest") Request newRequest, Model model) {
        model.addAttribute("bloodTypes",bloodTypeService.findAll());
        model.addAttribute("status",statusService.findAll());
        return "addRequest";
    }



    @RequestMapping(value="/add", method = RequestMethod.POST)
    //  @ResponseStatus(value = HttpStatus.NO_CONTENT )
    public String processAddRequestForm(@ModelAttribute("newRequest") @Valid Request requestToBeAdded , BindingResult result) {

        if(result.hasErrors())
            return "addBloodDrive";

        requestService.save(requestToBeAdded);


        return "redirect:/";
    }
}
