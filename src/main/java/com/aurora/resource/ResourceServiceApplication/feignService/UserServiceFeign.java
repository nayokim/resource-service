package com.aurora.resource.ResourceServiceApplication.feignService;

import com.aurora.resource.ResourceServiceApplication.dtos.UserDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * this enables the communication with user-service through feign client. The name attribute value should be the application name of the user-service mentioned in application. yml
 *
 * the rest of all the GET and POST mapping should be the same as API endpoints available in user-service controller. Then the feign client resolve the endpoints
 */

@FeignClient
public interface UserServiceFeign {

    @PostMapping("/api/saveUpdate")
    UserDetailsDTO saveUpdate(@RequestBody UserDetailsDTO inputUser);

    @GetMapping("/api/getById/{id}")
    UserDetailsDTO getUserById(@PathVariable Long id);

    @GetMapping("/api/getByName/{name}")
    List<UserDetailsDTO> getUserByName(@PathVariable String name);
}
