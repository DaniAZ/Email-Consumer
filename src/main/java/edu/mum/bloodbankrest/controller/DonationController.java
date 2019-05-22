package edu.mum.bloodbankrest.controller;


import edu.mum.bloodbankrest.domain.BloodDrive;
import edu.mum.bloodbankrest.domain.Donation;
import edu.mum.bloodbankrest.service.BloodDriveService;
import edu.mum.bloodbankrest.service.BloodTypeService;
import edu.mum.bloodbankrest.service.DonationService;
import edu.mum.bloodbankrest.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/donations")
public class DonationController {
    @Autowired
    private DonationService donationService;
    @Autowired
    private BloodTypeService bloodTypeService;
    @Autowired
    private DonorService donorService;


    @GetMapping({"","/all"})
    public String getAllDonations(Model model) {
          model.addAttribute("donations",donationService.findAll());
          System.out.println(donationService.findAll());
           return "donation";

    }

    @GetMapping("/{id}")
    public Donation getDonationById( @PathVariable("id") Long donationId) {

        return donationService.findOne(donationId);
    }

    @GetMapping(value = "/add")
    public String getAddNewDonationForm(@ModelAttribute("newDonation") Donation donation, Model model) {
      //  model.addAttribute("donors",donorService.findAll());
       //model.addAttribute("bloodTypes",bloodTypeService.findAll());
        return "addDonation";
    }



    @RequestMapping(value="/add", method = RequestMethod.POST)
    //  @ResponseStatus(value = HttpStatus.NO_CONTENT )
    public String processAddNewDonationForm(@ModelAttribute("newDonation") @Valid Donation donationTobeAddeded , BindingResult result) {

        if(result.hasErrors())
            return "addDonation";
        //this.bloodDrive.addDonation(donationTobeAddeded);
      ///  donationTobeAddeded.setDonationDate(LocalDate.now());
           donationService.save(donationTobeAddeded);


        return "redirect:/";
    }
}
