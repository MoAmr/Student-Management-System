package com.student.dal.controllers;

import com.student.dal.entities.Location;
import com.student.dal.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

    @Autowired
    LocationRepository locationRepo;

    @GetMapping
    public List<Location> getLocations() {
        return (List<Location>) locationRepo.findAll();
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationRepo.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location) {
        return locationRepo.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") int id) {
        locationRepo.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Location> getLocation(@PathVariable("id") int id) {
        return locationRepo.findById(id);
    }
}
