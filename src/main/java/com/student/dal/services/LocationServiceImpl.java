package com.student.dal.services;

import com.student.dal.entities.Location;
import com.student.dal.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepo;

    @Override
    public Location saveLocation(Location location) {
        return locationRepo.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepo.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        locationRepo.delete(location);
    }

    @Override
    public Optional<Location> getLocationById(int id) {
        return locationRepo.findById(id);
    }

    @Override
    public List<Location> getAllLocations() {
        return (List<Location>) locationRepo.findAll();
    }
}
