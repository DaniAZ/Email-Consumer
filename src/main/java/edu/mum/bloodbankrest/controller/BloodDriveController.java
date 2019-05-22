package edu.mum.bloodbankrest.controller;

import edu.mum.bloodbankrest.domain.BloodDrive;
import edu.mum.bloodbankrest.service.BloodDriveService;
import edu.mum.bloodbankrest.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/bloodDrives")
public class BloodDriveController {
    @Autowired
    private BloodDriveService bloodDriveService;
    @Autowired
    private StateService stateService;

    @GetMapping({"","/all"})
    public String getAllBloodDrive(Model model) {
        model.addAttribute ("bloodDrives",bloodDriveService.findAll());
         return "blooddrives";
    }

    @GetMapping("/{id}")
    public BloodDrive getBloodDriveById( @PathVariable("id") Long bloodDriveId) {

        return bloodDriveService.findOne(bloodDriveId);
    }
    @GetMapping(value = "/add")
    public String getAddNewBloodDriveForm(@ModelAttribute("newBloodDrive") BloodDrive newBloodDrive,Model model) {
        model.addAttribute("states",stateService.findAll());
        return "addBloodDrive";
    }



    @RequestMapping(value="/add", method = RequestMethod.POST)
  //  @ResponseStatus(value = HttpStatus.NO_CONTENT )
    public String processAddNewItemForm(@ModelAttribute("newBloodDrive") @Valid  BloodDrive bloodDriveToBeAdded ,BindingResult result) {

        if(result.hasErrors())
            return "addBloodDrive";

            bloodDriveService.save(bloodDriveToBeAdded);

        return "redirect:/bloodDrives";
    }

}
