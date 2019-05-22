package edu.mum.bloodbankrest.controller;


import edu.mum.bloodbankrest.domain.BloodDrive;
import edu.mum.bloodbankrest.domain.Donor;
import edu.mum.bloodbankrest.domain.Hospital;
import edu.mum.bloodbankrest.service.DonorService;
import edu.mum.bloodbankrest.service.HospitalService;
import edu.mum.bloodbankrest.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/hospitals")
@Controller
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private StateService stateService;

    @GetMapping({"","/all"})
    public String getAllHospitals(Model model) {
        model.addAttribute("hospitals",hospitalService.findAll());
         return "hospital";

    }

    @GetMapping("/{id}")
    public Hospital getHospitalById( @PathVariable("id") Long hospitalId) {

        return hospitalService.findOne(hospitalId);
    }

    @GetMapping(value = "/add")
    public String getAddNewBloodDriveForm(@ModelAttribute("newHospital") Hospital newHospital, Model model) {
        model.addAttribute("states",stateService.findAll());
        return "addHospital";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
   public String processAddHospitalForm(@Valid @ModelAttribute("newHospital") Hospital hospitalToBeAdded, BindingResult result) {
        if(result.hasErrors())
            return "addHospital";

        hospitalService.save(hospitalToBeAdded);
           System.out.println("after hospital");
            return "redirect:/";
    }
}
