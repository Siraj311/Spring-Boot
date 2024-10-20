package com.SpringCrud.SpringCrud.Repository;

import com.SpringCrud.SpringCrud.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

}