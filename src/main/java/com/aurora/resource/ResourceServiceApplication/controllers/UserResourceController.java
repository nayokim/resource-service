package com.aurora.resource.ResourceServiceApplication.controllers;

import com.aurora.resource.ResourceServiceApplication.dtos.UserDetailsDTO;
import com.aurora.resource.ResourceServiceApplication.feignService.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * this had the api endpoints which are available to the rest of the world. once a http api call is triggered by a user the resource-server communicate with user-service through feign client
 */

@RestController
@RequestMapping("/api")
public class UserResourceController {

    @Autowired
    private UserServiceFeign userServiceFeign;

    @PostMapping("/saveUpdate")
    public UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO inputUser){
        return userServiceFeign.saveUpdate(inputUser);
    }

    @GetMapping("/getById/{id}")
    public UserDetailsDTO getUserById(@PathVariable Long id){
        return userServiceFeign.getUserById(id);
    }

    @GetMapping("/getByName/{name}")
    public List<UserDetailsDTO> getUserByName(@PathVariable String name){
        return userServiceFeign.getUserByName(name);
    }

}
