package com.user.household.web;

import com.user.household.model.ApplicationEntityDTO;
import com.user.household.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApplianceController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/getById/{id}")
    public ApplicationEntityDTO getDetailsById(@PathVariable Integer id){
        return applicationService.getById(id);
    }

    @GetMapping("/getByName/{applianceName}")
    public List<ApplicationEntityDTO> getDetailsById(@PathVariable String name){
        return applicationService.getByApplianceName(name);
    }

    @PostMapping("/saveOrUpdate")
    public ApplicationEntityDTO saveOrUpdate(@RequestBody ApplicationEntityDTO applicationEntityDTO){
        return applicationService.save(applicationEntityDTO);
    }

    @DeleteMapping("/deleteById/{id}")
    public Map<String, Boolean> deleteById(@PathVariable Integer id){
        return applicationService.deleteById(id);
    }
}
