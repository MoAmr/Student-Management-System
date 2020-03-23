package com.student.dal.controllers;

import com.student.dal.entities.Location;
import com.student.dal.services.LocationService;
import com.student.dal.utils.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired
    LocationService locationService;

    @Autowired
    EmailUtil emailUtil;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createLocation";
    }

    @RequestMapping("/saveLocation")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        Location locationSaved = locationService.saveLocation(location);
        String msg = "location saved with id:" + locationSaved.getId();
        modelMap.addAttribute("msg", msg);
        emailUtil.sendEmail(
                "spring.test.mail.server@gmail.com",
                "Location Saved",
                "Location saved successfully and about to return a response.");
        return "createLocation";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap) {
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
        //Optional<Location> location = locationService.getLocationById(id);
        Location location = new Location();
        location.setId(id);
        locationService.deleteLocation(location);
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
        Optional<Location> location = locationService.getLocationById(id);
        Location editedLocation = new Location();
        editedLocation.setId(id);
        location.ifPresent(l -> {
            editedLocation.setName(l.getName());
            editedLocation.setCode(l.getCode());
            editedLocation.setType(l.getType());
        });
        modelMap.addAttribute("location", editedLocation);
        return "updateLocation";
    }

    @RequestMapping("/updateLocation")
    public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        locationService.updateLocation(location);
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }
}
