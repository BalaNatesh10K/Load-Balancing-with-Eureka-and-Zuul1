package com.user.service.feignservice;

import com.user.service.dto.ApplianceUserDTO;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;
import java.util.Map;

@FeignClient(name = "household-service")
public interface ResourceFeignService {

    @PostMapping("/appliance/saveOrUpdate")
    ApplianceUserDTO save(@RequestBody ApplianceUserDTO applianceUserDTO);

    @GetMapping("/appliance/getById/{id}")
    ApplianceUserDTO getById(@PathVariable Integer id);

    @GetMapping("/appliance/getByName/{name}")
    List<ApplianceUserDTO> getByApplianceName(@PathVariable String name);

    @DeleteMapping("/appliance/deleteById/{id}")
    Map<String, Boolean> deleteById(@PathVariable Integer id);
}
