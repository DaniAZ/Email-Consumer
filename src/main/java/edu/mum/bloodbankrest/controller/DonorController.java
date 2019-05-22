package edu.mum.bloodbankrest.controller;


import com.sun.glass.ui.Application;
import edu.mum.bloodbankrest.domain.BloodDrive;
import edu.mum.bloodbankrest.domain.Donation;
import edu.mum.bloodbankrest.domain.Donor;
import edu.mum.bloodbankrest.service.DonationService;
import edu.mum.bloodbankrest.service.DonorService;
import edu.mum.bloodbankrest.service.StateService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donors")
public class DonorController {

    @Autowired
    private DonorService donorService;
    @Autowired
    private StateService stateService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping({"","/all"})
    public String getAllDonors(Model model) {
        model.addAttribute("donors",donorService.findAll());
        return  "donor";

    }

    @GetMapping("/{id}")
    public Donor getDonorById( @PathVariable("id") Long donorId) {

        return donorService.findOne(donorId);
    }
    @GetMapping(value = "/add")
    public String getAddNewBloodDriveForm(@ModelAttribute("newDonor") Donor newDonor,Model model) {
        model.addAttribute("states",stateService.findAll());
           return "addDonor";
    }


    @PostMapping("/add")
    public String processAddNewItemForm(@ModelAttribute("newDonor") @Valid Donor donorToBeAdded , BindingResult result) {
      if(result.hasErrors())
          return "addDonor";

        donorService.save(donorToBeAdded);
        //rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
      //  receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);

          return "redirect:/";
    }
}
