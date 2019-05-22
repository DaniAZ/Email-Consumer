package edu.mum.bloodbankrest.controller;


import edu.mum.bloodbankrest.domain.BloodType;
import edu.mum.bloodbankrest.service.BloodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/bloodTypes")
@RestController
public class BloodTypeContoller {

    @Autowired
    private BloodTypeService bloodTypeService;

    @GetMapping({"","/all"})
    public List<BloodType> getAllBloodTypes(Model model) {
        return  (List<BloodType>)bloodTypeService.findAll();

    }
}
