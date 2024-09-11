package com.user.household.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.user.household.model.ApplicationEntity;
import com.user.household.model.ApplicationEntityDTO;
import com.user.household.repository.ApplicationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationEntityRepository applicationEntityRepository;

    @Transactional
    public ApplicationEntityDTO save(ApplicationEntityDTO applicationEntityDTO){
        ApplicationEntity applicationEntity = new ApplicationEntity();

        applicationEntity.setBrand(applicationEntityDTO.getBrand());
        applicationEntity.setModel(applicationEntityDTO.getModel());
        applicationEntity.setStatus(applicationEntityDTO.getStatus());

        return getDetails(applicationEntityRepository.save(applicationEntity));
    }

    public ApplicationEntityDTO getDetails(ApplicationEntity applicationEntity){
        return new ApplicationEntityDTO(
                applicationEntity.getSerialNumber(),
                applicationEntity.getBrand(),
                applicationEntity.getModel(),
                applicationEntity.getStatus()
        );
    }

    public List<ApplicationEntityDTO> getByApplianceName(String applianceName){
        List<ApplicationEntity> applicationEntityList = applicationEntityRepository.findByApplicationName(applianceName);

        if(CollectionUtils.isEmpty(applicationEntityList))
            return null;

        return applicationEntityList.stream().map(this::getDetails).collect(Collectors.toList());
    }

    public ApplicationEntityDTO getById(Integer serialId){
        return getDetails(applicationEntityRepository.getOne(serialId));
    }

    public Map<String, Boolean> deleteBy(Integer id){
        ApplicationEntity applicationEntity = applicationEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Appliance name not found with id: "+id));

        applicationEntityRepository.delete(applicationEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
