package com.SpringCrud.SpringCrud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringCrud.SpringCrud.Entity.Vehicle;
import com.SpringCrud.SpringCrud.Service.VehicleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
public class VehicleController {
  
  @Autowired
  private VehicleService vehicleService;

  @PostMapping("/addVehicle")
  public Vehicle postDetails(@RequestBody Vehicle vehicle) {
    return vehicleService.saveDetails(vehicle);
  }

  @GetMapping("/getVehicle")
  public List<Vehicle> getDetails() {
    return vehicleService.getAllDetails();
  }

  @GetMapping("/getVehicleByID/{id}")
  public Vehicle fetchDetailsById(@PathVariable int id) {
    return vehicleService.getVehicleDetailsById(id);
  }
  
}
