package com.SpringCrud.SpringCrud.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Vehicles")
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
  
  @Id
  @Column(name = "ID")
  @GeneratedValue
  private int id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "CITY")
  private String city;

  @Column(name = "DRIVER")
  private String driver;

  @Column(name = "IMGPATH")
  private String imgPath;

}
