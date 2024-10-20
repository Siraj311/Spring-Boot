package com.SpringCrud.SpringCrud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringCrud.SpringCrud.Entity.Vehicle;
import com.SpringCrud.SpringCrud.Repository.VehicleRepo;

@Service
public class VehicleService {

  @Autowired
  private VehicleRepo vehicleRepo;
  
  public Vehicle saveDetails(Vehicle vehicle) {
    return vehicleRepo.save(vehicle);
  }

  public List<Vehicle> getAllDetails() {
    return vehicleRepo.findAll();
  }

  public Vehicle getVehicleDetailsById(int id) {
    return vehicleRepo.findById(id).orElse(null);
  }
}
