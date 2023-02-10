package com.ibex.pms.controller;

import com.ibex.pms.domain.Property;
import com.ibex.pms.domain.dto.PropertyDto;
import com.ibex.pms.repository.PropertyRepo;
import com.ibex.pms.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/properties")
@CrossOrigin("*")
public class PropertyController {
    @Autowired
    PropertyService propertyService;


    @GetMapping
    public List<PropertyDto> getAllProperties(){
        return propertyService.getAllProperty();
    }





    @GetMapping("/{id}")
    public PropertyDto getProperty(@PathVariable long id){
        return  propertyService.getPropertyById(id);
    }
    @DeleteMapping("/{id}")
    public void deletePropertyById(@PathVariable long id ){
        propertyService.deletePropertyById(id);
    }
    @PutMapping("/{id}")
    public void updatePropertyById(@RequestBody Property property, @PathVariable long id){

        propertyService.updatePropertyById(property, id);

    }
    @PostMapping()
    public void createProperty(@RequestBody Property property){

        propertyService.saveProperty(property);

    }

   @PostMapping("/{userId}")
    public void addPropertyByUserId(@RequestBody Property property, @PathVariable long userId){
        propertyService.updatePropertyByUserId(property, userId);
    }
    @GetMapping("/search")
    public List<PropertyDto> getPropertyByCriteria(@RequestParam double price, @RequestParam int lotSize, @RequestParam int numberOfBedRooms, @RequestParam int numberOfBaths){
        return propertyService.getPropertyByCriteria(price,lotSize,numberOfBedRooms,numberOfBaths);
    }


}
