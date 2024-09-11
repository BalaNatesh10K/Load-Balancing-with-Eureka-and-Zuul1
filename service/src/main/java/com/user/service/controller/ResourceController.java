package com.user.service.controller;

import com.user.service.dto.ApplianceUserDTO;
import com.user.service.feignservice.ResourceFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appliance")
public class ResourceController {

    @Autowired
    private ResourceFeignService resourceFeignService;

    @GetMapping("/getById/{id}")
    public ApplianceUserDTO getDetailsById(@PathVariable Integer id){
        return resourceFeignService.getById(id);
    }

    @GetMapping("/getByName/{name}")
    public List<ApplianceUserDTO> getDetailsByName(@PathVariable String name){
        return resourceFeignService.getByApplianceName(name);
    }

    @PostMapping("/saveOrUpdate")
    public ApplianceUserDTO saveOrUpdate(@RequestBody ApplianceUserDTO applianceUserDTO){
        return resourceFeignService.save(applianceUserDTO);
    }
}
